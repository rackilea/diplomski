interface FutureFunc<R> {
    R get(long time, TimeUnit u) throws ExecutionException;
}
public FutureFunc<Result> getFuture() {
    CompletableFuture<A> resultA = serviceA.call();
    CompletableFuture<B> resultB = resultA.thenCompose(a -> serviceB.call(a));
    CompletableFuture<C> resultC = resultA.thenCompose(a -> serviceC.call(a));
    CompletableFuture<Result> optimistic = CompletableFuture.allOf(resultB, resultC)
        .thenApply(ignoredVoid -> combine(resultA.join(), resultB.join(), resultC.join()));
    return (t,u) -> {
        try {
            return optimistic.get(t, u);
        } catch (InterruptedException | TimeoutException ex) {
            return combine(resultA.join(), resultB.getNow(fallbackB),
                                           resultC.getNow(fallbackC));
        }
    };
}

public Result extractFuture(FutureFunc<Result> future) {
    Result result;
    try {
        result = future.get(timeOut, MILLISECONDS);
    } catch (ExecutionException ex) {
        ...
    }
    return result;
}