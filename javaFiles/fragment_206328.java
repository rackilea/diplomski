public static <T, K, V, M extends Map<K,V>> Collector<T, ?, M> toMap(
        Function<? super T, ? extends K> keyMapper,
        Function<? super T, ? extends V> valueMapper,
        Supplier<M> mapSupplier) {

    return Collector.of(mapSupplier,
            (m,t) -> putUnique(m, keyMapper.apply(t),
                                  Objects.requireNonNull(valueMapper.apply(t))),
            (m1,m2) -> {
                if(m1.isEmpty()) return m2;
                if(!m2.isEmpty()) m2.forEach((k,v) -> putUnique(m1, k, v));
                return m1;
            });
}
private static <K, V> void putUnique(Map<K, V> map, K key, V v1){
    V v2 = map.putIfAbsent(key, v1);
    if(v2 != null) throw new IllegalStateException(
        String.format("Duplicate key %s (values %s and %s)", key, v1, v2));
}