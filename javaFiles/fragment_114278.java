class Foo<K, V>
{
    private final Map<K, V> keyValue;
    private final Map<V, List<K>> valueKeys;

    {
        keyValue = new HashMap<K, V>();
        valueKeys = new HashMap<V, List<K>>();
    }

    public void put(final K key, final V value)
    {
        List<K> values;

        keyValue.put(key, value);

        values = valueKeys.get(value);

        if(values == null)
        {
            values = new ArrayList<K>();
            valueKeys.put(value, values);
        }

        values.add(key);
    }

    public V getValueForKey(final K key)
    {
        return (keyValue.get(key));
    }

    public List<K> getKeyForValue(final V value)
    {
        return (valueKeys.get(value));
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