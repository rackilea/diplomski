CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
    return "42";
}).thenAcceptAsync((dbl -> {
    pause(500);
    log.debug("Result: " + dbl);
}));