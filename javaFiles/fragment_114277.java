class Foo<K, V>
{
    private final Map<K, V> keyValue;
    private final Map<V, K> valueKey;

    {
        keyValue = new HashMap<K, V>();
        valueKey = new HashMap<V, K>();
    }

    // this makes sure that if you do not have duplicate values.
    public void put(final K key, final V value)
    {
        if(keyValue.containsValue(value))
        {
            keyValue.remove(valueKey.get(value));
        }

        keyValue.put(key, value);
        valueKey.put(value, key);
    }

    public V getValueForKey(final K key)
    {
        return (keyValue.get(key));
    }

    public K getKeyForValue(final V value)
    {
        return (valueKey.get(value));
    }

    public static void main(final String[] argv)
    {
        Foo<String, String> foo;

        foo = new Foo<String, String>();
        foo.put("a", "Hello");
        foo.put("b", "World");
        foo.put("c", "Hello");

        System.out.println(foo.getValueForKey("a"));
        System.out.println(foo.getValueForKey("b"));
        System.out.println(foo.getValueForKey("c"));

        System.out.println(foo.getKeyForValue("Hello"));
        System.out.println(foo.getKeyForValue("World"));
    }
}