private static final class FutureWithCancelCallback<V> extends ForwardingFuture.SimpleForwardingFuture<V> {

    private final Runnable callback;

    private FutureWithCancelCallback(Future<V> delegate, Runnable callback) {
        super(delegate);
        this.callback = callback;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
            boolean cancelled = super.cancel(mayInterruptIfRunning);
            if (cancelled) {
                callback.run();
            }
            return cancelled;
    }
}