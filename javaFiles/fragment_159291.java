class MyClass<K, V> {
    private HashMap<K, V> map = new HashMap<K, V>();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock rl = rwl.readLock();
    private Lock wl = rwl.writeLock();

    public V get(Object k) {
        rl.lock();
        try {
            return map.get(k);
        } finally {
            rl.unlock();
        }
    }

    public V put(K k, V v) {
        wl.lock();
        try {
            return map.put(k, v);
        } finally {
            wl.unlock();
        }
    }
}