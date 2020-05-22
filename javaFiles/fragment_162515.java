public static class SerialCaller<T> implements Callable<T> {
    private final BlockingQueue<Caller<T>> delegates;

    public SerialCaller(BLockingQueue<Caller<T>> delegates) {
        this.delegates = delegates;
    }

    public T call() throws Exception {
        return delegates.take().call();
    }
}