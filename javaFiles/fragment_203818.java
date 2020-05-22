private static <T> Stream<T> cartesian(BinaryOperator<T> aggregator,
                                       Supplier<Stream<T>>... streams) {
    return Arrays.stream(streams)
        .reduce((s1, s2) -> 
            () -> s1.get().flatMap(t1 -> s2.get().map(t2 -> aggregator.apply(t1, t2))))
        .orElse(Stream::empty).get();
}