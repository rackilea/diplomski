CompletableFuture<?> cancelAll = new CompletableFuture<>();
CompletableFuture<?>[] all = elements.stream()
    .map(e -> {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("entered "+e);
            if(shouldStop()) throw new RuntimeException("stopped");
            System.out.println("processing "+e);
        }, executor);
        cf.whenComplete((value,throwable) -> {
            if(throwable != null) cancelAll.completeExceptionally(throwable);
        });
        return cf;
    })
    .toArray(CompletableFuture<?>[]::new);
cancelAll.whenComplete((value,throwable) -> {
    for(CompletableFuture<?> cf: all) cf.completeExceptionally(throwable);
});
CompletableFuture.allOf(all).join();