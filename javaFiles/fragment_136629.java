class MyDelayBlockingQueue<T> implements Queue {
    private final DelayQueue<T> delayQ = ...
    private final BlockingQueue<T> blockingQ = ...

    public synchronized void offer(T obj) {
        blockingQ.offer(obj); // this will block if the Q is full
        delayQ.offer(obj);
    }

    public synchronized T poll() {
        T obj = delayQ.poll(); // This will handle the delay
        if (obj != null) {
            blockingQ.poll();
        }
        return obj;
    }

    // ...    
}