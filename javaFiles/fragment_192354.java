long start = System.nanoTime();

Map<String, Supplier<String>> input = new HashMap<>(2);
input.put("1", () -> {
    System.out.println(Thread.currentThread());
    LockSupport.parkNanos("simulated workload", TimeUnit.SECONDS.toNanos(2));
    return "a";
});
input.put("2", () -> {
    System.out.println(Thread.currentThread());
    LockSupport.parkNanos("simulated workload", TimeUnit.SECONDS.toNanos(2));
    return "b";
});
Map<String, String> results = input.keySet()
        .parallelStream().collect(Collectors.toConcurrentMap(
    key -> key,
    key -> input.get(key).get()));

System.out.println("Time: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime()- start));