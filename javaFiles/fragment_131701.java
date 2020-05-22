private final Map<String, AtomicInteger> cnts =
        new ConcurrentHashMap<>();

private void accumulate(String name) {
    cnts.computeIfAbsent(name, k -> new AtomicInteger()).incrementAndGet();
}