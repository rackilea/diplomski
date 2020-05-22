Future<T> future = null;
future = pool.submit(new Callable<T>() {
    public T call() {
        return executeImpl(url);
    }   
}); 

try {
    return future.get(10, TimeUnit.SECONDS);
}   
catch (InterruptedException e) {
    log.warn("task interrupted", name);
}   
catch (ExecutionException e) {
    log.error(name + " execution exception", e); 
}   
catch (TimeoutException e) {
    log.debug("future timed out", name);
}