Map<String, CompletableFuture<OlderCat>> completableFutures = cats
        .stream()
        .collect(toMap(Cat::getName, c -> asyncGetOlderCat(c.getName())));

CompletableFuture<Void> allFutures = CompletableFuture
        .allOf(completableFutures.values().toArray(new CompletableFuture[0]));

return allFutures.handle((dummy, ex) ->
        completableFutures.entrySet().stream()
                .filter(entry -> !entry.getValue().isCompletedExceptionally())
                .collect(toMap(Map.Entry::getKey, e -> e.getValue().join())));