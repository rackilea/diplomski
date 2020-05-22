class MyThread extends Thread {
  private boolean stop = false;

  public void run() {
    while(!stop) {
      doSomeWork();
    }
  }

  public void setStop() {
    this.stop = true;
  }
}