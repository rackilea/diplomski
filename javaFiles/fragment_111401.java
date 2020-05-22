private static CompletableFuture<?> composed(CompletableFuture<?> ... futures) {

    // Complete when ALL the underlying futures are completed
    CompletableFuture<?> allComplete = CompletableFuture.allOf(futures);

    // Complete when ANY of the underlying futures are exceptional
    CompletableFuture<?> anyException = new CompletableFuture<>();
    for (CompletableFuture<?> completableFuture : futures) {
        completableFuture.exceptionally((t) -> {
            anyException.completeExceptionally(t);
            return null;
        });
    }

    // Complete when either of the above are satisfied
    return CompletableFuture.anyOf(allComplete, anyException);
}