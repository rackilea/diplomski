public static CompletableFuture<Void> performAllItemsBackup(Stream<Item> items) {
    ForkJoinPool pool = new ForkJoinPool(3);
    try {
        return CompletableFuture.allOf(
            items.map(CompletableFuture::completedFuture)
                 .map(f -> f.thenAcceptAsync(performSingleItemBackup, pool))
                 .toArray(CompletableFuture<?>[]::new));
    } finally {
        pool.shutdown();
    }
}