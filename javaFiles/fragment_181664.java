CompletableFuture<Upload> future = expensiveService.processAndGet();
CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS)
    .execute(() -> {
        if(!future.isDone()) future.complete(resultService.get(processId));
    });
return future;