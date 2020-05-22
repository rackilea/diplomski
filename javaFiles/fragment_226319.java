interface Supplier<T> {
    T get();
} 

static <T> T computeIfAbsent(ConcurrentMap<K,T> map, T key, Supplier<? extends T> producer) {
    final T present = map.get(key);
    if (present != null) {
        return present;
    } else {
        final T fallback = producer.get();
        final T marker = map.putIfAbsent(key, fallback);
        if (marker == null) {
            return fallback;
        } else {
            return marker;
        }
    }
}