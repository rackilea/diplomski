public static <A, B> Pair<Stream<A>, Stream<B>> flatten(Iterator<Pair<Stream<A>, Stream<B>>> iterator) {

    Stream.Builder<Stream<A>> builderA = Stream.builder();
    Stream.Builder<Stream<B>> builderB = Stream.builder();

    iterator.forEachRemaining(pair -> {
        builderA.add(pair.first);
        builderB.add(pair.second);
    });

    return Pair.of(builderA.build().flatMap(Function.identity()), builderB.build().flatMap(Function.identity()));
}