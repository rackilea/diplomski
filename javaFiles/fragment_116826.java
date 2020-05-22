private ExecutorService executor = Executors.newCachedThreadPool();

public void populateData() {
    CompletableFuture
        .supplyAsync(this::fetchDataWithRetry, executor)
        .thenAccept(this::storeData);
}