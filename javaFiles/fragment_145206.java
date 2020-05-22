// create a thread pool with 10 workers
ExecutorService threadPool = Executors.newCachedThreadPool();
threadPool.submit(new Method1(x));
threadPool.submit(new Method2(x));
...
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();