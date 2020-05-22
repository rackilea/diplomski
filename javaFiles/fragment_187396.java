public CompletionStage<Object> tryWriteWithCleanup(Object foo) {
    return myBackend.tryWrite(foo)
            .handle((r, e) -> {
                if (e != null) {
                    return myBackend.tryCleanup(foo)
                            .handle((r2, e2) -> {
                                // Make sure we always return the original exception
                                // but keep track of new exception if any,
                                // as if run in a finally block
                                if (e2 != null) {
                                    e.addSuppressed(e2);
                                }
                                // wrapping in CompletionException  behaves as if
                                // we threw the original exception
                                throw new CompletionException(e);
                            });
                }
                return CompletableFuture.completedFuture(r);
            })
            .thenCompose(Function.identity());
}