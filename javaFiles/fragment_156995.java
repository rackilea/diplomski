class SupplierRetrier<T> implements Supplier<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierRetrier.class);
    final Supplier<T> wrappee;
    final int maxRetries;

    SupplierRetrier(Supplier<T> wrappee, int maxRetries) {
        Objects.requireNonNull(wrappee);
        if (maxRetries <= 0) {
            throw new IllegalArgumentException("maxRetries must be more than 0: " + maxRetries);
        }
        this.wrappee = wrappee;
        this.maxRetries = maxRetries;
    }

    @Override
    public T get() {
        RuntimeException lastException = null;
        for (int i = 0; i < maxRetries; i++) {
            try {
                LOGGER.info("MySupplier accept() Retry count: "+i);
                return wrappee.get();
            } catch (RuntimeException e) {
                lastException = e;
            }
        }
        throw lastException;
    }
}