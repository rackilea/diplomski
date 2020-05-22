public static <E> Set<Set<E>> getAllCombinations(Collection<E> inputSet) {
    // use inputSet.stream().distinct().collect(Collectors.toList());
    // to get only distinct combinations
    //  (in case source contains duplicates, i.e. is not a Set)
    List<E> input = new ArrayList<>(inputSet);
    final int size = input.size();
    // sort out input that is too large. In fact, even lower numbers might
    // be way too large. But using <63 bits allows to use long values
    if(size>=63) throw new OutOfMemoryError("not enough memory for "
        +BigInteger.ONE.shiftLeft(input.size()).subtract(BigInteger.ONE)+" permutations");

    // the actual operation is quite compact when using the Stream API
    return LongStream.range(1, 1L<<size) /* .parallel() */
        .mapToObj(l -> BitSet.valueOf(new long[] {l}).stream()
            .mapToObj(input::get).collect(Collectors.toSet()))
        .collect(Collectors.toSet());
}