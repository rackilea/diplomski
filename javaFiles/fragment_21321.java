// this will start a new thread for every job
ExecutorService threadPool = Executors.newCachedThreadPool();
threadPool.submit(new MyRunnable(0, 2));
threadPool.submit(new MyRunnable(2, 4));
// once you've submitted your last task, you shutdown the pool
threadPool.shutdown();
// then we wait until all of the tasks have run
threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);