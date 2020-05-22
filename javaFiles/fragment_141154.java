List<CompletableFuture<DBResult>> listFutureResult =
                     listRequest.stream()
                                .map(req -> CompletableFuture.supplyAsync(
                                              () -> dbLaunchRequest(req), executor))
                                .collect(Collectors.toList());    
List<DBResult> listResult = 
                     listFutureResult.stream()
                                     .map(CompletableFuture::join)
                                     .collect(Collectors.toList());