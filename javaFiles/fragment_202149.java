public class ScheduledTask implements Runnable {
    // Configurable values
    private static final int CORE_THREAD_POOL_SIZE = 1;
    private static final int INITIAL_DELAY_MS = 0;
    private static final int INTERVAL_MS = 1000;

    private final ScheduledExecutorService scheduledExecutorService = 
        Executors.newScheduledThreadPool(ScheduledTask.CORE_THREAD_POOL_SIZE);

    private ScheduledFuture<?> scheduledFuture;

    public void run() {
        try {
            try {
                // Do stuff
            } catch RecoverableCheckedException rce { // E.g. SAXException
                // Log and handle appropriately
            }
        } catch UnrecoverableCheckedException uce { // E.g. ParserConfigurationException
            // Not 100% happy with this. It means the caller would need to call
            // getCause() to get the real Exception in this case. But other 
            // RuntimeExceptions wouldn't be wrapped. Could consider catching
            // and wrapping all RuntimeExceptions but I like that even less!
            throw new RuntimeException(uce);
        }
    }

    public boolean isScheduling() {
        return (this.scheduledFuture != null)
               && (!this.scheduledFuture.isDone());
    }

    // May not be needed but provided in case this class is shared.
    public boolean isShutdown() {
        return scheduledExecutorService.isShutdown();
    }

    public void start() {
        // If the Executor Service has already been shutdown, would expect
        // a RejectedExecutionException to be thrown here(?) Not sure what
        // would happen if this method were called when isScheduling() is
        // true?
        this.scheduledFuture = 
            this.scheduledExecutorService.scheduleWithFixedDelay(
                this,
                ScheduledTask.INITIAL_DELAY_MS,
                ScheduledTask.INTERVAL_MS,
                TimeUnit.MILLISECONDS);
    }

    // To be called once at the very end - e.g. on program termination.
    public void shutdown() {
        this.scheduledExecutorService.shutdown();
    }
}