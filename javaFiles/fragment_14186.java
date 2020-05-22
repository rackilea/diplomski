CompletableFuture<String> supply = CompletableFuture.supplyAsync(() -> {
    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
    System.out.println("supplying value");
    return "foo";
});
CompletableFuture<String> then = supply.thenApply(s -> {
    System.out.println("Evaluating next stage");
    return s;
});
CompletableFuture<?> last = then.handle((s,t) -> {
    System.out.println("last stage: value: "+s+", throwable: "+t);
    return "";
});
System.out.println("cancelling: "+supply.cancel(true));
ForkJoinPool.commonPool().awaitQuiescence(1, TimeUnit.DAYS);