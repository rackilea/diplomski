// Decorate the executor service with listening
ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

// Submit the task
ListenableFuture<Integer> future = service.submit(new Callable<Integer>() {
    public Integer call() throws Exception {
        return new Integer(1234);
    }
});

// Transform the future to get rid of the memory consumption
// The transformation must happen asynchronously, thus the 
// Executor parameter is vital
Futures.transform(future, new AsyncFunction<Integer, Integer>() {
    public ListenableFuture<Integer> apply(Integer input) {
        return Futures.immediateFuture(input);
    }
}, service);