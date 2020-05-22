Thread readingThread = new Thread(new Runnable() {
  @Override
  public void run() {
    //do reading here...
  }
});
readingThread.start();

Thread writingThread = new Thread(new Runnable() {
  @Override
  public void run() {
    //do writing here...
  }
});
writingThread.start();