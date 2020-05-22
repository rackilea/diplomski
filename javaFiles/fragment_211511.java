// reate an open-ended thread pool
ExecutorService threadPool = Executors.newCachedThreadPool();
// since you want results from the validate methods, we need a list of Futures
Future<Result> futures = new ArrayList<Result>();
futures.add(threadPool.submit(new Callable<Result>() {
    public Result call() {
       return a.ValidateA();
    } 
});
futures.add(threadPool.submit(new Callable<Result>() {
    public Result call() {
       return a.ValidateB();
    } 
});
// once we have submitted all jobs to the thread pool, it should be shutdown,
// the already submitted jobs will continue to run
threadPool.shutdown();

// we wait for the jobs to finish so we can get the results
for (Future future : futures) {
    // this can throw an ExecutionException if the validate methods threw
    Result result = future.get();
    // ...
}