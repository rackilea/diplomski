//where initialization occurs:
MyListener myListener = new MyListener();
addMouseListener(myListener);
addMouseMotionListener(myListener);

private class MyListener extends MouseInputAdapter {
  public void mousePressed(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    // you may not need this method
  }

  public void mouseDragged(MouseEvent e) {
    // do your code
  }

  public void mouseReleased(MouseEvent e) {
    // reset your variables
  }