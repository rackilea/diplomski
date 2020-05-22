Supplier<R> sup = ...;
CompletableFuture<R> future = new CompletableFuture<R>();
ForkJoinPool.commonPool().submit(() -> {
     try {
        R result = sup.get();
        future.complete(result);
    } catch (Throwable e) {
        future.completeExceptionally(e);
    }
});
return future;