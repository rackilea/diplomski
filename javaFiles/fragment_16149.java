class LooperThread extends Thread {
  public Handler mHandler;

  public void run() {
      Looper.prepare();

      mHandler = new Handler() {
          public void handleMessage(Message msg) {
              // process incoming messages here
          }
      };

      synchronized (this) {
          this.notifyAll();
      }

      Looper.loop();
  }
}