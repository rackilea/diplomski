public static CompletableFuture<String> divideByZero() {
    return CompletableFuture.supplyAsync(() -> {
        int x = 5 / 0;
        return "hi there";
    });
}