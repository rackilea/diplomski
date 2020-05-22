import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * A HashMap that removes objects after the set TTL
 */
public class ExpiringMap<K, V> implements Map<K, V> {
    private final int DEFAULT_TTL = 30;
    private final HashMap<K, ScheduledFuture<K>> cacheKeys = new HashMap<K, ScheduledFuture<K>>();
    private final HashMap<K, V> theHash = new HashMap<K, V>();
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return theHash.size();
    }

    @Override
    public boolean isEmpty() {
        return theHash.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return theHash.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return theHash.containsValue(value);
    }

    /**
     * If retrieving an object that already exists in the cache 
     * we must resets the TTL timer on that item.
     */
    @SuppressWarnings("unchecked")
    @Override
    public V get(final Object key) {
        // If item exists in cache, then we cancel and reset the timer on that item
        if(cacheKeys.containsKey(key) && cacheKeys.get(key).cancel(false)) {
            ScheduledFuture<K> task = executorService.schedule(new Callable<K>() {
                @Override
                public K call() {
                    cacheKeys.remove(key);
                    theHash.remove(key);
                    return (K) key;
                }
            }, DEFAULT_TTL, TimeUnit.SECONDS);
            cacheKeys.put((K) key, task);
        }
        return theHash.get(key);
    }

    /**
     * When we add an item to cache we add the key to a map that contains FutureScheduled 
     * events that will remove the item after TTL
     */
    @Override
    public V put(final K key, V value) {
        ScheduledFuture<K> task = executorService.schedule(new Callable<K>() {
            @Override
            public K call() {
                cacheKeys.remove(key);
                theHash.remove(key);
                return key;
            }
        }, DEFAULT_TTL, TimeUnit.SECONDS);
        cacheKeys.put(key, task);
        return theHash.put(key, value);
    }

    @Override
    public V remove(Object key) {
        cacheKeys.remove(key);
        return theHash.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // TODO implement

    }

    @Override
    public void clear() {
        cacheKeys.clear();
        theHash.clear();
    }

    @Override
    public Set<K> keySet() {
        return theHash.keySet();
    }

    @Override
    public Collection<V> values() {
        return theHash.values();
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return theHash.entrySet();
    }

}