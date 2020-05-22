List<CompletableFuture<RoomTypes.RoomType>> completableFutures = new ArrayList<>(); //List to hold all the completable futures
ExecutorService yourOwnExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

for (Map.Entry<Integer, List> entry : map1.entrySet()) {
    CompletableFuture<RoomTypes.RoomType> requestCompletableFuture = CompletableFuture
            .supplyAsync(
                    () ->
                //API call which returns object of type RoomTypes.RoomType
                updateService.updateRoom(51, 33, 759, entry.getKey(),
                        new RoomTypes.RoomType(entry.getKey(), map2.get(entry.getKey()),
                                entry.getValue())),
                    yourOwnExecutor
            );

    completableFutures.add(requestCompletableFuture);
}

CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]))
        // avoid throwing an exception in the join() call
        .exceptionally(ex -> null)
        .join();
Map<Boolean, List<CompletableFuture<RoomTypes.RoomType>>> result =
        completableFutures.stream()
                .collect(Collectors.partitioningBy(CompletableFuture::isCompletedExceptionally)));