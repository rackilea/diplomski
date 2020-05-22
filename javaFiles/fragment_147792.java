public static CompletableFuture allOfTerminateOnFailure(CompletableFuture<?>... futures) {
    CompletableFuture<?> failure = new CompletableFuture();
    for (CompletableFuture<?> f: futures) {
        f.exceptionally(ex -> {
            failure.completeExceptionally(ex);
            return null;
        });
    }
    return CompletableFuture.anyOf(failure, CompletableFuture.allOf(futures));
}