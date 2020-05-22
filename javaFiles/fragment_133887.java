@SafeVarargs
public static <T> int chainedCompare(T object1, T object2, Comparator<T>... comparators) {
    return Arrays.stream(comparators)
                 .reduce(Comparator::thenComparing)
                 .map(c -> c.compare(object1, object2))
                 .orElse(0);
}