component.addMouseListener(new MouseAdapter(){
  public void mousePressed(MouseEvent e){
    mouseDown = true;
  }
  public void mouseReleased(MouseEvent e){
    mouseDown = false;
  }
});