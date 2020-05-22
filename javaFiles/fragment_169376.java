<T> Stream<T> repeat(Supplier<Stream<T>> stream) {
    return Stream.generate(stream).flatMap(s -> s);
}

<T> Stream<T> repeat(Collection<T> collection) {
    return Stream.generate(() -> collection.stream()).flatMap(s -> s);
}