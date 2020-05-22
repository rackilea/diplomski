class Accumulator {
    private final AtomicLong[] values = {
        new AtomicLong(0),
        new AtomicLong(0),
        new AtomicLong(0),
        new AtomicLong(0),
    };
    public void accumulate(long value) {
        int index = getMagicValue();
        this.values[index % values.length].addAndGet(value);
    }
    public long get() {
        long result = 0;
        for (AtomicLong value : values) {
            result += value.get();
        }
        return result;
    }
}