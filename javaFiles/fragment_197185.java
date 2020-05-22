public static <K,V> Pair<K,V> getMinKeyValue(
    Map<K, ? extends Collection<V>> map, Comparator<? super V> function) {

    return map.entrySet().stream()
        .map(e->new Pair<>(e.getKey(), e.getValue().stream().min(function).get()))
        .min(Comparator.comparing(Pair::getRight, function)).get();
}