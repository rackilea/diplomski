private static <T, C extends Collection<T>> Stream<C> comb(
        List<? extends Collection<T>> values, int offset, Prefix<T> prefix,
        Supplier<C> supplier) {
    if (offset == values.size() - 1)
        return values.get(offset).stream()
                     .map(e -> new Prefix<>(prefix, e).addTo(supplier.get()));
    return values.get(offset).stream()
            .flatMap(e -> comb(values, offset + 1, new Prefix<>(prefix, e), supplier));
}