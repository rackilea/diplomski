new Thread() {
  @Override public void run() {
    try {
        strum();
    } catch ( InterruptedException e ) { e.printStackTrace(); }
  }
}.start();