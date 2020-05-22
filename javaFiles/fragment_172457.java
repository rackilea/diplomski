public class Poller implements Runnable {
    final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    Future future = null;

    @Override
    public void run() {
        ...
    }

    public void startPolling() {
        if (future != null && !future.isDone()) {
           future.cancel(true); // stop before restarting
           // or
           return; // already running
        }
        future = exec.scheduleWithFixedDelay(this, 0, 5000, TimeUnit.MILLISECONDS);
    }
}