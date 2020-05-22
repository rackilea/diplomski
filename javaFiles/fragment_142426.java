ExecutorService executor = Executors.newFixedThreadPool(1);
Future<?> future = executor.submit(yourTask);
try {
    future.get(1, TimeUnit.HOURS);
} catch (TimeoutException e) {
    future.cancel(true);
    resubmitWithMoreResources();
} catch (ExecutionException e) {
    Throwable underlyingCause = e.getCause();
    if (underlyingCause instanceof ResourceException) {
        resubmitWithMoreResources();
    } else {...}
}