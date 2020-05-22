ExecutorService threadPool; //initialised somewhere earlier

Future<ResultType> futureResult = threadPool.submit(new MyCallable());
try {
    ResultType result = futureResult.get(100, TimeUnit.MILLISECONDS);
    //results received in time, do the processing here
} catch(TimeoutException e) {
    //request too slow -- handle it
} catch( other exceptions...) { ... }