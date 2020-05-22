public FutureFunc<Result> getFuture() {
    CompletableFuture<A> resultA = serviceA.call();
    CompletableFuture<B> resultB = resultA.thenCompose(a -> serviceB.call(a));
    CompletableFuture<C> resultC = resultA.thenCompose(a -> serviceC.call(a));
    CompletableFuture<Void> bAndC = CompletableFuture.allOf(resultB, resultC);
    CompletableFuture<Result> result = bAndC
        .thenApply(ignoredVoid -> combine(resultA.join(), resultB.join(),
                                                          resultC.join()));
    return (t,u) -> {
        try {
            bAndC.get(t, u);
        } catch (InterruptedException|TimeoutException ex) {
            resultB.complete(fallbackB);
            resultC.complete(fallbackC);
        }
        try {
            return result.get();
        } catch (InterruptedException ex) {
            throw new ExecutionException(ex);
        }
    };
}