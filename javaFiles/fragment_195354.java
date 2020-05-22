Map<Integer, Integer[]> map = createLRUMap(128);

public static <K, V> Map<K, V> createLRUMap(final int maxSize) {
    return new LinkedHashMap<K,V>(maxSize, 1, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return size() > maxSize;
        }
    };
}