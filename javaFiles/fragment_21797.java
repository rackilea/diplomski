public class MyCollections {
    private static final String UNMODIFIABLE_MAP_CLASS_NAME =
        Collections.unmodifiableMap(new HashMap()).getClass().getName();

    public static <K, V> Map<K, V> unmodifiableMap(Map<K, V> map) {
        return map.getClass().getName().equals(UNMODIFIABLE_MAP_CLASS_NAME)
                 ? map
                 : Collections.unmodifiableMap(map);
    }
}