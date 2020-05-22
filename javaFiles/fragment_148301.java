public <K, V, C extends Collection<V>, M extends Map<K, C>> M getMap(List<V> list,
        Function<? super V, ? extends K> classifier, Supplier<M> mapSupplier, Supplier<C> collectionSupplier) {
    return list.stream().collect(
        Collectors.groupingBy(classifier, mapSupplier, Collectors.toCollection(collectionSupplier))
    );
}