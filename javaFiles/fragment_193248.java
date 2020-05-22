public class LazyCache<T> implements Supplier<T> {
    private final Supplier<T> supplier;

    private volatile Supplier<T> cache;

    public LazyCache(Supplier<T> supplier) {
        this.supplier = supplier;
        reset();
    }

    private void reset() {
        cache = new MemoizingSupplier<T>(supplier);
    }

    @Override
    public T get() {
        return cache.get();
    }

    public void invalidate() {
        reset();
    }

    private static class MemoizingSupplier<T> implements Supplier<T> {
        final Supplier<T> delegate;
        volatile T value;

        MemoizingSupplier(Supplier<T> delegate) {
            this.delegate = delegate;
        }

        @Override
        public T get() {
            if (value == null) {
                synchronized (this) {
                    if (value == null) {
                        value = delegate.get();
                    }
                }
            }
            return value;
        }
    }
}