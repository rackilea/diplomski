public class MyHashMap<K, V> extends HashMap<K, V> {
     private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public V put(K key, V value) {
        final Lock w = lock.writeLock();
        w.lock();
        try {
            return super.put(key, value);
        } finally {
            w.unlock();
        }
    }

    @Override
    public V get(Object key) {
        final Lock r = lock.readLock();
        r.lock();
        try {
            return super.get(key);
        } finally {
            r.unlock();
        }
    }
    .... // the same approach distinguishing read and write operations

}