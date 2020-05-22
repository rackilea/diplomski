private final ConcurrentMap<String, AtomicInteger> cnts =
        new ConcurrentHashMap<>();

private void accumulate(String name) {
    cnts.putIfAbsent(name, new AtomicInteger());
    cnts.get(name).incrementAndGet();
}