import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

public class ManyToMany<K, V> {
    private final SetMultimap<K, V> keysToValues = HashMultimap.create();

    private final SetMultimap<V, K> valuesToKeys = HashMultimap.create();

    public Set<V> getValues(K key) {
        return keysToValues.get(key);
    }

    public Set<K> getKeys(V value) {
        return valuesToKeys.get(value);
    }

    public boolean put(K key, V value) {
        return keysToValues.put(key, value) && valuesToKeys.put(value, key);
    }

    public boolean putAll(K key, Iterable<? extends V> values) {
        boolean changed = false;
        for (V value : values) {
            changed |= put(key, value);
        }
        return changed;
    }
}