public static class WithThreadLocal<V, T> implements Callable<V> {
    private final ThreadLocal<T> threadLocal;
    private final T              value;
    private final Callable<V>    callable;


    public WithThreadLocal(ThreadLocal<T> threadLocal, T value, Callable<V> callable) {
        this.threadLocal = threadLocal;
        this.value = value;
        this.callable = callable;
    }

    @Override
    public V call() throws Exception {
        T oldValue = threadLocal.get();
        try {
            threadLocal.set(value);
            return callable.call();
        } finally {
            threadLocal.set(oldValue);
        }
    }
}