public ContinuousCompletableFuture<Void> thenAcceptAsync(
                                         BiConsumer<? super T, Long> action) {
    CompletionStage<Long> elapsedTime=CompletableFuture.completedFuture(getElapsedTime());
    return new ContinuousCompletableFuture<>(
        baseFuture.thenAcceptBothAsync(elapsedTime, action), creationTime);
}