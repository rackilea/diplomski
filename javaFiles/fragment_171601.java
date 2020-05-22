public class MemoryAwait {

    private Lock lock = new ReentrantLock();
    private Condition memoryAvailable = lock.newCondition();


    public MemoryAwait() {
        ScheduledExecutorService schedule = (ScheduledExecutorService) Executors.newSingleThreadExecutor();
        schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (enoughFreeMemory()) {
                    memoryAvailable.notify();
                }
            }
        }, 0, 60, TimeUnit.SECONDS);
    }

    public void check() throws InterruptedException {
        try {
            lock.lock();
            while (!enoughFreeMemory()) {
                memoryAvailable.await();
            }
        } finally {
            lock.unlock();
        }
    }

    private boolean enoughFreeMemory() {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        return allocatedMemory / maxMemory < 0.9;
    }
}