public static <K, V> Map<K, V> createLRUMap(final int maxEntries) {
    Map<K,V> result = new LinkedHashMap<K, V>(maxEntries*3/2, 0.7f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maxEntries;
        }
    };
    return Collections.synchronizedMap(result);
}