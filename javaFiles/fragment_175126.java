@Override
public void paintComponent(Graphics g) {
  super.paintComponent(g);
  // draw background
  g.setColor(backgroundColor);
  g.fillRect(0, 0, getWidth(), getHeight());
  // draw your stuff here
}