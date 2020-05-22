public class BoundConcurrentHashMap <K,V> {
    private final Map<K, V> m;
    private final Semaphore semaphore;
    public BoundConcurrentHashMap(int size) {
        m = new ConcurrentHashMap<K, V>();
        semaphore = new Semaphore(size);
    }

    public V get(V key) {
        return m.get(key);
    }

    public boolean put(K key, V value) {
        boolean hasSpace = semaphore.tryAcquire();
        if(hasSpace) {
            m.put(key, value);
        }
        return hasSpace;
    }

    public void remove(Object key) {
        m.remove(key);
        semaphore.release();
    }

    // approximation, do not trust this method
    public int size(){
        return m.size();
    }
}