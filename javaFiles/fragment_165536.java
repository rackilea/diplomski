public static F.Promise<Void> performAllItemsBackup(Stream<Item> items) {
    ExecutorService pool = Executors.newFixedThreadPool(3);
    try {
        return CompletableFuture.allOf(
            items.map(CompletableFuture::completedFuture)
                 .map(f -> f.thenAcceptAsync(performSingleItemBackup, pool))
                 .toArray(CompletableFuture<?>[]::new))
            .handle((v, e) -> e!=null? F.Promise.<Void>throwing(e): F.Promise.pure(v))
            .join();
    } finally {
        pool.shutdown();
    }
}