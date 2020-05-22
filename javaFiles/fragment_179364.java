Promise<Integer> p = new DefaultPromise<Integer>(down -> DefaultExecution.require().delimit(down::error, continuation ->
        continuation.resume(() -> down.success(12))
)) {
    @Override
    public Promise<Integer> cacheResultIf(Predicate<? super ExecResult<Integer>> shouldCache) {
        return transform(up -> {
            return new TestCachingUpstream<>(up, shouldCache.function(Duration.ofSeconds(-1), Duration.ZERO));
        });
    }
};