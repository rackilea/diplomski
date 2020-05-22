MouseListener mouseListener = new MouseAdapter() {
  public void mousePressed(MouseEvent mouseEvent) {
      System.out.println("I'm pressed: " + mouseEvent);
  }
  public void mouseReleased(MouseEvent mouseEvent)  {
      System.out.println("I'm released: " + mouseEvent);
  }
};