static <T> Stream<Collection<T>> cartesianProduct(Collection<Collection<Collection<T>>> arr)
{
    return arr.stream()
        .<Supplier<Stream<Collection<T>>>> map(c -> c::stream)
        .reduce((s1, s2) -> () -> s1.get().flatMap(
                a -> s2.get().map(b -> Stream.concat(a.stream(), b.stream())
                        .collect(Collectors.toList()))))
        .orElseGet(() -> () -> Stream.<Collection<T>>of(Collections.emptyList()))
        .get();
}