public final class MapBuilder<K, V>
{
    private final Map<K, V> map = new HashMap<K, V>();

    public MapBuilder<K, V> put(final K key, final V value)
    {
        map.put(key, value);
        return this;
    }

    public Map<K, V> build()
    {
        // Return a mutable copy, so that the builder can be reused
        return new HashMap<K, V>(map);
    }

    public Map<K, V> immutable()
    {
        // Return a copy wrapped into Collections.unmodifiableMap()
        return Collections.unmodifiableMap(build());
    }
}