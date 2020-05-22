ExecutorService es = ForkJoinPool.commonPool();
Integer result = es.invokeAny(IntStream.range(0, 100)
    .mapToObj(i -> mapAndfilter(i,
        n -> {
            long delay = ThreadLocalRandom.current().nextInt(10_000);
            log("Waiting on " + n + " for " + delay + " ms");
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(delay));
            return n * n;
        },
        n -> n < 10_000))
    .collect(Collectors.toList()));

log("result: "+result);