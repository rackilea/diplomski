@SafeVarargs
@SuppressWarnings("varargs")
static <C extends Comparable<C>> Comparator<Action>
comparatorWith(Function<Action, ? extends C>... extractors) {
    return Arrays.stream(extractors)
                 .map(ex -> comparing(ex, nullsLast(naturalOrder())))
                 .reduce(Comparator::thenComparing)
                 .orElseThrow(() -> new IllegalArgumentException("need at least one extractor"));
}