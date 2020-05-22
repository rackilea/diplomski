List<CompletableFuture<MyResult>> futures = myInputList.stream()
    .map(myService::getResultFuture)
    .collect(Collectors.toList());
CompletableFuture.allOf(futures.toArray(CompletableFuture<?>[]::new))
    .thenRun(() -> {
        List<MyResult> results = futures.stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList());
        // perform action with results
    });