public static <T, U, A, R>
Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper,
                           Collector<? super U, A, R> downstream) {
    BiConsumer<A, ? super U> downstreamAccumulator = downstream.accumulator();
    return new CollectorImpl<>(downstream.supplier(),
                               (r, t) -> downstreamAccumulator.accept(r, mapper.apply(t)),
                               downstream.combiner(), downstream.finisher(),
                               downstream.characteristics());
}