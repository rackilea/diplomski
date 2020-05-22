default <U> CompletableFuture<U> submit(Supplier<U> supplier) {
    return CompletableFuture.supplyAsync(supplier, ....)
            .whenComplete((u, ex) -> {
                if (ex != null) {
                    handleThrowable(ex);
                }
            });
}