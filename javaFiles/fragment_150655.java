CompletableFuture<A> aCompletionStage = getA().toCompletableFuture();
CompletableFuture<B> bCompletionStage = getB().toCompletableFuture();
CompletableFuture<C> cCompletionStage = getC().toCompletableFuture();
CompletableFuture<D> dCompletionStage = getD().toCompletableFuture();

CompletionStage<Combined> combinedDataCompletionStage = CompletableFuture.allOf(
    aCompletionStage, bCompletionStage, cCompletionStage, dCompletionStage)
    .thenApply(ignoredVoid -> combine(
        aCompletionStage.join(), bCompletionStage.join(),
        cCompletionStage.join(), dCompletionStage.join()) );