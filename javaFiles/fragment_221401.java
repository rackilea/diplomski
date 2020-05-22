int poolSize = ...;
int queueSize = ...;
RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();

ExecutorService executorService = new ThreadPoolExecutor(poolSize, poolSize,
    0L, TimeUnit.MILLISECONDS,
    new LinkedBlockingQueue<>(queueSize),
    handler);