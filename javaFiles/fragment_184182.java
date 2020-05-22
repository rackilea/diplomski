ExecutorService threadPool = Executors.newFixedThreadPool(2);
// spawn our jobs into the pool
Future<Integer> future1 = threadPoll.submit(new Callable<Integer>() { ... });
Future<integer> future2 = threadPool.submit(new Callable<Integer>() { ... });
// once all jobs have been submitted you shutdown the pool
threadPool.shutdown();
// the get() methods here wait for the threads to finish and return a value
int x = future1.get() + future2.get();