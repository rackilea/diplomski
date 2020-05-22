public class ListBackedMap<T, K, V> extends AbstractMap<K, V> {
    private final List<T> list;
    private final BiFunction<K, V, T> keyValueToElement;
    private final Function<T, K> elementToKey;
    private final Function<T, V> elementToValue;

    public ListBackedMap(List<T> list, BiFunction<K, V, T> keyValueToElement, Function<T, K> elementToKey, Function<T, V> elementToValue) {
        this.list = list;
        this.keyValueToElement = keyValueToElement;
        this.elementToKey = elementToKey;
        this.elementToValue = elementToValue;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return list.stream()
                .collect(toMap(elementToKey, elementToValue))
                .entrySet();
    }

    @Override
    public V put(K key, V value) {
        V previousValue = remove(key);
        list.add(keyValueToElement.apply(key, value));
        return previousValue;
    }

    public List<T> getList() {
        return list;
    }
}