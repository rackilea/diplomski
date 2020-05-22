final ConcurrentMap<Path, AtomicLong> counterMap = new ConcurrentHashMap<>();

public void incrementFor(Path path) {
    counterMap.computeIfAbsent(path, p -> new AtomicLong()).incrementAndGet();
}

public long getCount(Path path) {
    AtomicLong l = counterMap.get(path);
    return l == null ? 0 : l.get();
}