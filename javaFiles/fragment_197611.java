CompletableFuture
        .completedFuture(null)
        .thenCompose(v -> exceptional)
        .handle(unwrappingCompletionException((result, throwable) -> {
            […]
        }));