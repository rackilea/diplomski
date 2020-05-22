/**
 * Actually needs some refactoring
 * Also, did not verify for atomicity - should be redesigned
 */
public V theServiceCall(final T param) {
    final MyResultBuffer<V> buffer = new MyResultBuffer<V>();
    Runnable task = new Runnable() {
        public void run() {
            V result = ejb.process(param);
            buffer.putResult(result);
        }
    }
    Thread t = new Thread(task);
    t.setDaemon(true);
    t.start();
    try {
        t.join(TASK_TIMEOUT_MILLIS);
    } catch (InterruptedException e) {
        // Handle it as needed (current thread is probably asked to terminate)
    }
    return (t.isAlive()) ? null : buffer.getResult();
}