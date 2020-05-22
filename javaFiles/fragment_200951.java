import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringBackedHashMap<K, V> extends HashMap<K, V> implements StringBackedMap<K, V> {

    private static final long serialVersionUID = 1L;

    private Map<String, V> backerMap;

    public StringBackedHashMap() {
        super();

        init();
    }

    public StringBackedHashMap(int capacity) {
        super(capacity);

        init();
    }

    public StringBackedHashMap(int capacity, float loadFactor) {
        super(capacity, loadFactor);

        init();
    }

    public StringBackedHashMap(Map<? extends K, ? extends V> map) {
        super(map);

        init();

        putAll(map);
    }

    private void init() {
        this.backerMap = new HashMap<String, V>();
    }

    @Override
    public V get(String key) {
        return this.backerMap.get(key);
    }

    @Override
    public V get(Object key) {
        V value = super.get(key);

        if (value == null) {
            value = this.backerMap.get(key.toString());
        }

        return value;
    }

    @Override
    public boolean containsKey(String key) {
        return this.backerMap.containsKey(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(key) || this.backerMap.containsKey(key);
    }

    @Override
    public Set<String> backerKeySet() {
        return this.backerMap.keySet();
    }

    @Override
    public Set<Entry<String, V>> backerEntrySet() {
        return this.backerMap.entrySet();
    }

    @Override
    public V put(K key, V value) {
        V oldValue = super.put(key, value);

        this.backerMap.put(key.toString(), value);

        return oldValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        super.putAll(map);

        if ((map != null) && (!map.isEmpty())) {
            for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
                this.backerMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
    }

    @Override
    public V remove(Object key) {
        V oldValue = super.remove(key);

        this.backerMap.remove(key.toString());

        return oldValue;
    }

    @Override
    public void clear() {
        super.clear();

        this.backerMap.clear();
    }

}