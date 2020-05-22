MouseInputAdapter mia = new MouseInputAdapter() {
  @Override
  public void mouseDragged(MouseEvent e) { ... }
  @Override
  public void mousePressed(MouseEvent e) { ... }
};
addMouseListener(mia);
addMouseMotionListener(mia); // <-- You're missing this one.