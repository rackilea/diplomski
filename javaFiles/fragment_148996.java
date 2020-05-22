public class MyThread extends Thread {
    public volatile int times = 0;

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                times += 1;
                Thread.sleep(500);
                if (i == 5) {
                    synchronized(this) {
                        this.notify();
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}