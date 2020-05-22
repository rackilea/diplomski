public static <K, VN, V> Stream<Entry<K, V>> filterAndMapValue(Map<K, VN> map,
    Predicate<? super Entry<K, VN>> predicate,
    Function<? super Entry<K, VN>, ? extends V> mapper) {

    return map.entrySet().stream().filter(predicate)
              .map(e->new AbstractMap.SimpleEntry<>(e.getKey(), mapper.apply(e)));
}