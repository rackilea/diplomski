public class RunWithTimeout {

    public RunWithTimeout(Runnable r, long timeout) {
        // Prepare the thread.
        final Thread t = new Thread(r);
        // Start the timer.
        new Timer(true).schedule(new TimerTask() {

            @Override
            public void run() {
                if (t.isAlive()) {
                    // Abort the thread.
                    t.interrupt();
                }
            }
        }, timeout * 1000);
        // Start the thread.
        t.start();
    }

}

class WaitAFewSeconds implements Runnable {

    final long seconds;

    WaitAFewSeconds(long seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ie) {
            System.out.println("WaitAFewSeconds(" + seconds + ") - Interrupted!");
        }
    }

}

public void test() {
    new RunWithTimeout(new WaitAFewSeconds(5), 3);
    new RunWithTimeout(new WaitAFewSeconds(3), 5);
}