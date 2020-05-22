public JFrame frame = new JFrame();
public JPanel pan = new JPanel();

public void replace() {
  frame.remove(pan);
  pan = new JPanel();
  GridLayout grid = new GridLayout(8,8);
  pan.setLayout(grid);
  pan.setVisible(true);
  frame.add(pan);
  frame.invalidate();
  frame.revalidate();
  frame.repaint();
  frame.pack();
  frame.setVisible(true);
}