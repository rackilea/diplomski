static final Supplier<AtomicInteger> newAtomicInteger = new Supplier<AtomicInteger>() {
    public AtomicInteger get() { return new AtomicInteger(0); }
};

void yourMethodWhatever(Object tag) {
    final AtomicInteger counter = computeIfAbsent(cancelretryCountMap, tag, newAtomicInteger);
    if (counter.incrementAndGet() > 10) {
        ... whatever ...
    }
}