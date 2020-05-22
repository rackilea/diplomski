CompletionStage<E> someMethod() {
    return doSomething()
            .thenCompose(this::processA);
}

private CompletionStage<E> processA(final A a) {
    // ...
    Foo foo = fooDAO.getFoos(a);
    // ...
    final CompletableFuture<B> result = ...;
    return result
            .thenCompose(this::processB)
            .thenCompose(c -> processCAndFoo(c, foo));
}

private CompletionStage<C> processB(B b) {
    // ...
    return ...;
}

private CompletionStage<E> processCAndFoo(final C c, final Foo foo) {
    // ...
    Bar bar = barDAO.getBars(foo);
    // ...
    final CompletableFuture<D> result = ...;
    return result
            .thenApply(d -> someResult(d, bar));
}