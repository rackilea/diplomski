if (event.getSource() == b) {
Thread th=new Thread() {
  public void run() {
    b.setText("1");
    try {
      Thread.sleep(5000);                        
    }catch (Exception e) {
    }
    b.setText("2");
    try {
      Thread.sleep(5000);                        
    }catch (Exception e) {
    }
    b.setText("3");   
  }
};
th.start();
}