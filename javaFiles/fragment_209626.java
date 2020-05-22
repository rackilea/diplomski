class Accumulator {
    private final AtomicLong value = new AtomicLong(0);
    public void accumulate(long value) {
        this.value.addAndGet(value);
    }
    public long get() {
        return this.value.get();
    }
}