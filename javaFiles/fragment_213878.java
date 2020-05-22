static<T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> com) {
    return CompletableFuture.allOf(com.toArray(new CompletableFuture<?>[0]))
            .thenApply(v -> com.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList())
            );
}