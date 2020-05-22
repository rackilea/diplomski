class MyThread
        extends Thread {

    private Handler myHandler;

    public MyThread() {
        start();
    }

    @Override
    public void run() {
        Looper.prepare();
        Looper looper = Looper.myLooper();
        myHandler = new Handler(looper);
        Looper.loop();
    }
}