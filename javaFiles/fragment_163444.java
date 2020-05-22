public class MyLRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int maxEntries;

    public MyLRUCache(int maxEntries) {
        // you can be a bit fancy with capacity and load factor
        super(16, 0.75, true);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }
}