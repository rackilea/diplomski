static ForkJoinPool setUpForkJoinPool() {
    int numThreads;
    try {
        String configuredNumThreads = System.getProperty("maxParallelTestThreads");
        numThreads = Math.max(2, Integer.parseInt(configuredNumThreads));
    } catch (Exception ignored) {
        Runtime runtime = Runtime.getRuntime();
        numThreads = Math.max(2, runtime.availableProcessors());
    }
    ForkJoinPool.ForkJoinWorkerThreadFactory threadFactory = pool -> {
        if (pool.getPoolSize() >= pool.getParallelism()) {
            return null;
        } else {
            ForkJoinWorkerThread thread = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
            thread.setName("JUnit-" + thread.getName());
            return thread;
        }
    };
    return new ForkJoinPool(numThreads, threadFactory, null, false);
}