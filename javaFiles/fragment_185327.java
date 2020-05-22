<T> Consumer<T> combine(Stream<? extends Consumer<? super T>> consumers) {

    Consumer<T> identity = t -> {};
    BiFunction<Consumer<T>, Consumer<? super T>, Consumer<T>> acc = Consumer::andThen;
    BinaryOperator<Consumer<T>> combiner = Consumer::andThen;

    return consumers.filter(Objects::nonNull)
                    .reduce(identity, acc, combiner);
}