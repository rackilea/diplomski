public Optional<Float> davidist(
        Stream<Float> stream, Predicate<Float> tester, BinaryOperator<Float> op) {

    return stream           // Elements stream
            .filter(tester) // Stream of elements that passed 'tester' test
            .reduce(op);    // Optional<Float> resulting by reducing elements using 'op'
}