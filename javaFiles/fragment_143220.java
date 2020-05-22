ExecutorService executorService = Executors.newCachedThreadPool();

List<CompletableFuture<Void>> futures = new ArrayList<>();
for (int i = 0; i < 10; ++i) {
    futures.add(CompletableFuture.runAsync(
                     () -> {
                         // do work here and return
                         return work
                      },executorService)
                      .exceptionally(e -> {
                           logger.error("Error here"+e);
                           return null;
                       })
      );
}
CompletableFutre.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();