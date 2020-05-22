public final class CustomMap<K, V>
    implements Map<K, V>
{
    private final Map<K, V> delegate;

    public CustomMap(final Map<K, V> delegate)
    {
        this.delegate = delegate;
    }

    @Override
    public V put(final K key, final V value)
    {
        // Can't use the return value of delegate.put(), since some implementations
        // allow null values; so checking delegate.put() == null doesn't work
        if (delegate.containsKey(key))
            throw new IllegalArgumentException("duplicate key: " + key);
        return delegate.put(key, value);
    }

    @Override
    public void putAll(@Nonnull final Map<? extends K, ? extends V> m)
    {
        for (final Entry<? extends K, ? extends V> entry: m.entrySet())
            put(entry.getKey(), entry.getValue());
    }

    // delegate all other methods
}