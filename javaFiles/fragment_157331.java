public class FolderWork implements Runnable {
    private final Executor executor;
    private final File folder;

    private final AtomicInteger pendingItems = new AtomicInteger(0);
    private final CountDownLatch latch = new CountDownLatch(1);

    public FolderWork(Executor executor, File folder) {
        this.executor = executor;
        this.folder = folder;
    }

    @Override
    public void run() {
        for (File file : folder.listFiles()) {
            enqueueMoreWork(file);
        }
    }

    public void enqueueMoreWork(File file) {
        if (latch.getCount() == 0) {
            throw new IllegalStateException(
                "Cannot call enqueueMoreWork() again after awaitCompletion() returns!");
        }
        pendingItems.incrementAndGet();
        executor.execute(new FileWork(file, this));
    }

    public void markWorkItemCompleted() {
        int remainingItems = pendingItems.decrementAndGet();
        if (remainingItems == 0) {
            latch.countDown();
        }
    }

    public boolean hasPendingWork() {
        return pendingItems.get() > 0;
    }

    public void awaitCompletion() {
       latch.await();
    }
}