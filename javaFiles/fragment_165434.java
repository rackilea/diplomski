@Override
public void keyPressed(KeyEvent evt) {
  final JComponent comp = (JComponent) evt.getSource();
  int keyCode = evt.getKeyCode();
  boolean shiftIsDown = evt.isShiftDown();
  currentCell.selected = ((shiftIsDown & (keyCode == RIGHT | keyCode == UP
        | keyCode == LEFT | keyCode == DOWN)));
  if (currentCell.selected) {
     SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           comp.setFont(fontSelected);
        }
     });
  }
}