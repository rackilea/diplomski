public static<T,A,R,RR> Collector<T,A,RR> collectingAndThen(Collector<T,A,R> downstream,
                                                            Function<R,RR> finisher) {
    // ... some characteristics transformations ...
    return new CollectorImpl<>(downstream.supplier(),
                               downstream.accumulator(),
                               downstream.combiner(),
                               downstream.finisher().andThen(finisher),
                               characteristics);
}