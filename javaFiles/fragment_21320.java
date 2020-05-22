public class MyRunnable implements Runnable {
    private final int start;
    private final int end;
    public MyRunnable(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public void run() {
        for (int i = start; i < end; i++) {
            myfn(i);
        }
    }
}