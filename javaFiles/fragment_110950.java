class T extends Frame {
  public T() {
    setSize(500, 500);
    setLayout(new GridLayout(5, 5));
    for(int i=0; i<25; i++) add(new Label(""+i));
    setVisible(true);
  }
  public static void main(String args[]) {
    T t=new T();
    for(int i=0; i<5; i++) {
      int r=(int)(Math.random()*25);
      t.remove(r);
      t.add(new Label(""+(i+1)), r);
      t.validate();
      t.repaint();
      try { Thread.sleep(5000); } catch(InterruptedException ie) {}
    }
  }
}