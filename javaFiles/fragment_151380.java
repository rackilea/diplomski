JTextField textField = new JTextField(10);
textField.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e) {
  char c = e.getKeyChar();
  if (//Write your condition here) {
     e.consume();  // ignore event
}});