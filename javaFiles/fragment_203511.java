queries.stream()
    .map(query -> CompletableFuture.supplyAsync(...))
    .collect(toList())
    .stream()
    .map(CompletableFuture::join)
    .collect(toList());