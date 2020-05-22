CompletableFuture<?> f = new CompletableFuture<>();
executionService.execute(() -> {
    if(!f.isDone()) {
        try {
            f.complete(supplier.get());
        }
        catch(Throwable t) {
            f.completeExceptionally(t);
        }
    }
});