static class MultiQueue<K, V> {

    // The base structure.
    final ConcurrentMap<K, BlockingQueue<V>> queues = new ConcurrentHashMap<>();

    /**
     * Put an item in the structure.
     *
     * The entry in the map will be created if no entry is currently there.
     *
     * The value will then be posted to the queue.
     */
    public void put(K k, V v) throws InterruptedException {
        // Make it if not present.
        ensurePresence(k).put(v);
    }

    /**
     * Get an item from the structure.
     *
     * The entry in the map will be created if no entry is currently there.
     *
     * The value will then be taken from the queue.
     */
    public void get(K k) throws InterruptedException {
        // Make it if not present - and wait for it.
        ensurePresence(k).take();
    }

    private BlockingQueue<V> ensurePresence(K k) {
        // Make it if not present.
        return queues.computeIfAbsent(k, v -> new ArrayBlockingQueue(1));
    }
}