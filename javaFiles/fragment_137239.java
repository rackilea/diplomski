public static <T, C extends Collection<T>> Stream<C> ofCombinations(
        Collection<? extends Collection<T>> values, Supplier<C> supplier) {
    if (values.isEmpty())
        return Stream.empty();
    return comb(new ArrayList<>(values), 0, null, supplier);
}