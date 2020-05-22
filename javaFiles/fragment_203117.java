Set<Integer> addTwoPrefixes(final int base) {
    final int prefix = base * 100;
    return IntStream
            .rangeClosed(1, 4).map(i -> i * 10)
            .flatMap(i -> IntStream.rangeClosed(1, 4).map(j -> i + j))
            .map(i -> base + i)
            .boxed()
            .collect(toCollection(LinkedHashSet::new));
}