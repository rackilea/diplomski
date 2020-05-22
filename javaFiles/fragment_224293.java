public static CompletableFuture<Integer> findMatch(List<Integer> inputs) {
    return findMatch(inputs, 0);
}

private static CompletableFuture<Integer> findMatch(List<Integer> inputs, int startIndex) {
    if (startIndex >= inputs.size()) {
        // no match found -- an exception could be thrown here if preferred
        return CompletableFuture.completedFuture(null);
    }
    return pseudoAsyncCall(inputs.get(startIndex))
            .thenCompose(result -> {
                if (result) {
                    return CompletableFuture.completedFuture(inputs.get(startIndex));
                } else {
                    return findMatch(inputs, startIndex + 1);
                }
            });
}