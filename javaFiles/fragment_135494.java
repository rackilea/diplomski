static <T> Collector<T[], ?, T[]> reducingByColumn(
        T identity,
        BinaryOperator<T> operator,
        IntFunction<T[]> factory) {

    return Collector.of(
        HashMap<Integer, T>::new,
        (map, a) -> IntStream.range(0, a.length)
            .forEach(i -> map.merge(i, a[i] == null ? identity : a[i], operator)),
        (m1, m2) -> {
            m2.forEach((k, v) -> m1.merge(k, v, operator));
            return m1;
        },
        map -> map.values().toArray(factory.apply(map.size())));
}