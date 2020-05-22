fillStatus.addActionListener(new ActionListener() {
  // t1 was initialized false
  public void actionPerformed(ActionEvent event) {
    if (filling == false) {
      fillStatus.setText("Filling");
      // if false, change t1 status to true
      t1.flip();
      // and send the notification to the startFill thread that it has changed
      synchronized (t1) {
        t1.notify();
      }
    } else {
      fillStatus.setText("Not Filling");
      // if true, change t1 status to false
      t1.flip();
      // no notification required due to polling nature of startFill's active thread
    }
    filling = !filling;
    System.out.println("fill button press");
  }
});