@Override
default V computeIfAbsent(K key,
        Function<? super K, ? extends V> mappingFunction) {
    Objects.requireNonNull(mappingFunction);
    V v, newValue;
    return ((v = get(key)) == null &&
            (newValue = mappingFunction.apply(key)) != null &&
            (v = putIfAbsent(key, newValue)) == null) ? newValue : v;
}