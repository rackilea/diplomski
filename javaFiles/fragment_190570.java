public class Memoized<T> {
    private boolean initialized;
    private Supplier<T> supplier;

    public Memoized(Supplier<T> supplier) {
        this.supplier = () -> {
            synchronized(this) {
                if(!initialized) {
                    T value = supplier.get();
                    this.supplier = () -> value;
                    initialized = true;
                }
            }
            return this.supplier.get();
        };
    }

    public T get() {
        return supplier.get();
    }
}