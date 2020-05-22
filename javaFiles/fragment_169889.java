ThreadPoolBulkhead bulkhead = ThreadPoolBulkhead.ofDefaults("sample");
TimeLimiter timeLimiter = TimeLimiter.of(Duration.ofSeconds(1));

ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
CompletableFuture<String> future = timeLimiter
    .executeCompletionStage(scheduler, 
        bulkhead.decorateSupplier(() -> service.method())).toCompletableFuture();