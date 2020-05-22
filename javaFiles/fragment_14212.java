class KeyEntry<K, V> implements Map.Entry<K, V> {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeyEntry)) {
            return false;
        }

        KeyEntry keyEntry = (KeyEntry) o;

        if (!key.equals(keyEntry.key)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "{\"KeyEntry\":{" +
                "\"key\": \"" + key + "\"" +
                ", \"value\": \"" + value + "\"" +
                "}}";
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    KeyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException("NO!");
    }

    private final K key;
    private final V value;


}