component.addKeyListener(new KeyAdapter(){
  public void keyPressed(KeyEvent e){
    if(mouseDown){
      System.out.println("the key was pressed while the mouse is down.");
    }
  }
});