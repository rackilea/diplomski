/**
 * Creates a new thread pool based on some attributes
 * @param poolSize the number of worker threads in the thread pool
 * @param poolName the name of the thread pool (for debugging purposes)
 * @param priority the base priority of the worker threads
 * @param capacity the size of the task queue used
 * @return the ExecutorService object
 */
private ExecutorService newPool(int poolSize, 
String poolName, final int priority, int capacity) {
    int cpu = Runtime.getRuntime().availableProcessors();
    ExecutorService result = null;
    if (poolSize != 0) {
        if (poolSize == -1) {
            poolSize = cpu;
        }
        if (capacity <= 0) {
            capacity = Integer.MAX_VALUE;
        }
        result = new ThreadPoolExecutor(poolSize, poolSize, 
                120, TimeUnit.MINUTES, 
                new LinkedBlockingQueue<Runnable>(capacity), 
        new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread t = new Thread(runnable);
                t.setPriority(priority);
                return t;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r,
                    ThreadPoolExecutor executor) {
                if (!executor.isShutdown()) {
                    try {
                        executor.getQueue().put(r);
                    } catch (InterruptedException ex) {
                        // give up
                    }
                }
            }
        });
    }
    return result;
}