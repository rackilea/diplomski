public static <T, K, D, A, M extends Map<K, D>>
Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
                              Function<Void,M> mapFactory,                                 
                              Collector<? super T, A, D> downstream) {
    return Collectors.groupingBy(classifier, () -> mapFactory.apply(null), downstream);
}