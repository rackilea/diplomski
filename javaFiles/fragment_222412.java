public CompletableFuture<Result> getFuture(long timeOut, TimeUnit u) {
    CompletableFuture<A> resultA = serviceA.call();
    CompletableFuture<B> resultB = resultA.thenCompose(a -> serviceB.call(a));
    CompletableFuture<C> resultC = resultA.thenCompose(a -> serviceC.call(a));
    ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();
    e.schedule(() -> resultB.complete(fallbackB), timeOut, u);
    e.schedule(() -> resultC.complete(fallbackC), timeOut, u);
    CompletableFuture<Void> bAndC = CompletableFuture.allOf(resultB, resultC);
    bAndC.thenRun(e::shutdown);
    return bAndC.thenApply(ignoredVoid ->
                           combine(resultA.join(), resultB.join(), resultC.join()));
}