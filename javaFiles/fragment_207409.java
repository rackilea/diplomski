public class ThreadOne extends Thread {
    private Looper mLooper = null;

    @Override
    public void run() {
        Looper.prepare();
        mLooper = Looper.myLooper();

        Looper.loop();
    }

    Looper getLooper() {
        return mLooper;
    }
}