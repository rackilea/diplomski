CompletableFuture<List<T>> result = CompletableFuture.allOf(com.toArray(new CompletableFuture<?>[0]))
        .thenApply(v -> com.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList())
        );

com.forEach(f -> f.whenComplete((t, ex) -> {
    if (ex != null) {
        result.completeExceptionally(ex);
    }
}));

return result;