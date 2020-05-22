SwingWorker<String, Object> sw = new SwingWorker<String, Object>() {
  @Override
  public String doInBackground() {
    // do the real work here
  }
  // override other methods as needed
}
// instead of calling sw.execute() start the background thread yourself:
Thread t1 = new Thread(sw);
t1.setPriority(Thread.MAX_PRIORITY);
t1.start();