/**
 * Returns a collector which joins the results of supplied collectors
 * into the single string using the supplied delimiter.
 */
@SafeVarargs
public static <T> Collector<T, ?, String> joining(CharSequence delimiter, 
        Collector<T, ?, ?>... collectors) {
    @SuppressWarnings("unchecked")
    Collector<T, Object, Object>[] cs = (Collector<T, Object, Object>[]) collectors;
    return Collector.<T, Object[], String>of(
        () -> Stream.of(cs).map(c -> c.supplier().get()).toArray(), 
        (acc, t) -> IntStream.range(0, acc.length)
            .forEach(idx -> cs[idx].accumulator().accept(acc[idx], t)), 
        (acc1, acc2) -> IntStream.range(0, acc1.length)
            .mapToObj(idx -> cs[idx].combiner().apply(acc1[idx], acc2[idx]))
            .toArray(), 
        acc -> IntStream.range(0, acc.length)
            .mapToObj(idx -> cs[idx].finisher().apply(acc[idx]).toString())
            .collect(Collectors.joining(delimiter)));
}