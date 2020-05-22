// A single threaded executor service that cannot have more than 1 task in its task queue
// such that I know that if I provide at least 3 tasks, at least 1 task will be rejected. 
// Why 3? 1 task in the queue + 1 task executed by the thread of the pool 
// = max of tasks that the pool can manage at a given time, so if I add 1 it will be
// rejected.
ExecutorService executor = new ThreadPoolExecutor(
    1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1),
    Executors.defaultThreadFactory(), myHandler
);

// My Counter
AtomicInteger counter = new AtomicInteger();
// Some arbitrary task that lasts long enough to make sure that at least 3
// tasks will be submitted that will increment my counter once completed
Runnable task = () -> {
    try {
        Thread.sleep(1_000L);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    } finally {
        counter.incrementAndGet();
    }
};
try {
    // Submit 3 tasks
    executor.submit(task);
    executor.submit(task);
    executor.submit(task);
} finally {
    // Shutdown the pool and wait until all the submitted tasks have been executed
    executor.shutdown();
    executor.awaitTermination(1L, TimeUnit.MINUTES);
}
// Ensure that we have 3 tasks that have been executed
assertEquals(3, counter.get());