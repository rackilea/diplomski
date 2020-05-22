CompletionStage<E> someMethod() {
    return doSomething().thenCompose(a -> {
        // ...
        Foo foo = fooDAO.getFoos(a);
        // ...
        CompletableFuture<B> resultB = ...;
        return resultB.thenCompose(b -> {
            // ...
            CompletableFuture<C> resultC = ...;
            return resultC;
        }).thenCompose(c -> {
            // ...
            Bar bar = barDAO.getBars(foo);
            // ...
            CompletableFuture<D> resultD = ...;
            return resultD.thenApply(d -> {
                // ...
                return someResult(d, bar);
            });
        });
    });
}