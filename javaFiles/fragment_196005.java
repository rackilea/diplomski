public class ExampleMap<K, V> extends HashMap<K, V> {

    V getOrDefault1(Object key, V defaultValue) {
        V v;
        return ((v = get(key)) != null) || containsKey(key) ? v : defaultValue;
    }

    V getOrDefault2(Object key, V defaultValue) {
        V v = get(key);
        return v != null || containsKey(key) ? v : defaultValue;
    }
}