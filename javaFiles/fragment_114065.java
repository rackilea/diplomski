public class LongRunningThread extends Thread {
    private volatile boolean IS_RUNNING = true;

    @Override
    public void run() {
        while (IS_RUNNING) {
            try {
                // actions
                this.houseKeep();
            } catch (Exception e) {
            }
        }
    }

    private void houseKeep() {
        // housekeeping logic here
    }

}

class ThreadWatcher {
    private Thread threadToBeWatched;

    public ThreadWatcher(Thread threadToBeWatched) {
        this.threadToBeWatched = threadToBeWatched;
    }

    @Scheduled(cron = "*/1 * * * *")
    public void checkStatus() {
        if (!threadToBeWatched.isAlive()) {
            // Logic to restart the thread.
        }
    }
}