public class BackgroundQueue implements Runnable {

    private final ExecutorService service;
    private final Queue<Runnable> tasks = new ConcurrentLinkedQueue<>();
    private final AtomicBoolean running = new AtomicBoolean(false);
    private Future<?> future;

    public BackgroundQueue(ExecutorService service) {
        this.service = Objects.requireNonNull(service);
        // Create a Future that immediately returns null
        FutureTask f = new FutureTask<>(() -> null);
        f.run();
        future = f;
    }

    public void awaitQueueTermination() throws InterruptedException, ExecutionException {
        do {
            future.get();
        } while (!tasks.isEmpty() || running.get());
    }

    public synchronized void submit(Runnable task) {
        tasks.add(task);
        if (running.compareAndSet(false, true))
            future = service.submit(this);
    }

    @Override
    public void run() {
        while (!running.compareAndSet(tasks.isEmpty(), false)) {
            tasks.remove().run();
        }
    }
}