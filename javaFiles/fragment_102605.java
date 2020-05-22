public class Cache<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_ENTRIES = 100;

    public Cache() {
        super(SOME_INITIAL_CAPACITY, SOME_LOAD_FACTOR, true);
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > MAX_ENTRIES;
    }
}