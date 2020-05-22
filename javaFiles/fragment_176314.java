final class SizedSuppliedSpliterator<T> implements Spliterator<T> {
    private int remaining;

    private final Supplier<T> supplier;

    private SizedSuppliedSpliterator(Supplier<T> supplier, int remaining) {
        this.remaining = remaining;
        this.supplier = supplier;
    }

    static <T> SizedSuppliedSpliterator of(Supplier<T> supplier, int limit) {
        return new SizedSuppliedSpliterator(supplier, limit);
    }

    @Override
    public boolean tryAdvance(final Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer);
        if (remaining > 0) {
            remaining--;
            final T supplied = supplier.get();
            consumer.accept(supplied);
            return true;
        }
        return false;
    }

    @Override
    public void forEachRemaining(final Consumer<? super T> consumer) {
        while (remaining > 0) {
            consumer.accept(supplier.get());
            remaining--;
        }
    }

    @Override
    public SizedSuppliedSpliterator<T> trySplit() {
        int split = (int)remaining/2;
        remaining -= split;
        return new SizedSuppliedSpliterator<>(supplier, split);
    }

    @Override
    public long estimateSize() {
        return remaining;
    }

    @Override
    public int characteristics() {
        return SIZED | SUBSIZED | IMMUTABLE;
    }
}