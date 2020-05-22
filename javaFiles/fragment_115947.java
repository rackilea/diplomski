CompletableFuture<SomeObject> f1Future = CompletableFuture.supplyAsync(() -> f1());

CompletableFuture<SomeObject> future = f1Future.
            thenApplyAsync(f1Output -> f2(f1Output)).
            thenApplyAsync(f2Output -> f3(f2Output));

f1Future.thenAcceptAsync(f1Output -> f4(f1Output));