List<Integer> nums = IntStream.range(0, 200).boxed().collect(Collectors.toList());
Optional<Integer> num = nums.parallelStream()
        .map(n -> {
            long delay = ThreadLocalRandom.current().nextInt(10_000);
            log("Waiting on " + n + " for " + delay + " ms");
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(delay));
            return n * n;
        })
        .filter(n -> n < 40_000)
        .peek(n -> log("Found match: " + n))
        .findAny();

log("First match: " + num);