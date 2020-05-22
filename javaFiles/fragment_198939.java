private static <T> Optional<Stream<T>> isConsumed(Stream<T> stream) {

    Spliterator<T> spliterator;
    try {
        spliterator = stream.spliterator();
    } catch (IllegalStateException ise) {
        return Optional.empty();
    }

    return Optional.of(StreamSupport.stream(
        () -> spliterator,
        spliterator.characteristics(),
        stream.isParallel()));
}