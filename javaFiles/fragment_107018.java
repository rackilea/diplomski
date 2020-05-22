// turn a Stream<Integer> to an IntStream with a 
// int applyAsInt(Integer i) aka ToIntFunction<Integer>
Stream.of(1, 2, 3).mapToInt(i -> i * 2)
Stream.of(1, 2, 3).mapToInt(i -> { return i * 2; })

// turn an IntStream to a different IntStream with a 
// int applyAsInt(int i) aka IntUnaryOperator
IntStream.of(1, 2, 3).map(i -> i * 2)
IntStream.of(1, 2, 3).map(i -> { return i * 2; })

// turn an IntStream to a Stream<Integer> with a 
// Integer apply(int i) aka IntFunction<Integer>
IntStream.of(1, 2, 3).mapToObj(i -> i * 2)
IntStream.of(1, 2, 3).mapToObj(i -> { return i * 2; })