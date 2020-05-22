private static final Object lock = new Object();
private static ScheduledFuture<?> currentRunningTask;

    public void longPoll() {

        synchronized (lock) {

            if (currentRunningTask != null) {
                currentRunningTask.cancel(true);
            }

            try {
                currentRunningTask = pollingScheduledExecutor.scheduleAtFixedRate(this, 0, 3, TimeUnit.SECONDS);
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
    }