final int end=progBar.getValue() + times;
progBar.addChangeListener(new ChangeListener() {
  public void stateChanged(ChangeEvent e) {
    if(progBar.getValue()==end) {
      System.out.println("all jobs finished");
    }
  }
});
for(int x = 0; x < times; x = x+1) {
  new Thread("T") {
    public void run() {
      try {                                              
          Thread.sleep(5000);
      } catch(InterruptedException ex) {
          Thread.currentThread().interrupt();
      }
      SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                progBar.setValue(progBar.getValue()+1);
              }
      });
    }
  }.start();