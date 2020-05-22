class LooperThread extends Thread {
  public Handler mHandler;
  private volatile Looper mMyLooper;

  public void run() {
    Looper.prepare();

    mHandler = new Handler() {
       public void handleMessage(Message msg) {
          // process incoming messages here
       }
    };

    mMyLooper = Looper.getMyLooper();

    Looper.loop();
  }

  public void killMe(){
     mMyLooper.quit();
  }
}