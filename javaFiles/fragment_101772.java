BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(QUEUE_SIZE);
ExecutorService threadPool = new ThreadPoolExecutor(NUM_INITIAL_THREADSs,
            MAX_NUM_THREADS, 0L, TimeUnit.MILLISECONDS, queue);
...
// submit the jobs...
// after submitting the jobs, you need to shutdown the queue
threadPool.shutdown();