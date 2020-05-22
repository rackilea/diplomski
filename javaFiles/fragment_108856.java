public MyFrame extends JFrame{


  public JFrame add(Container container){
    super.add(container);
    return this;
  }

  public JFrame setLocation(int x, int y){
    super.setLocation(x,y);
    return this;
  }
  //and so on
}