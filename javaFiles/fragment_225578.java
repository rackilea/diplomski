Thread t = new Thread(new Runnable() {
  public void run() {
    while (!stopped) {
      // do something interesting here
    }
  }
});
t.start();