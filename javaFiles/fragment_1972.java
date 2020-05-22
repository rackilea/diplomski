public static <C extends Collection<E>, E> C collectValues(
        Map<?, ? extends Collection<? extends E>> map, Supplier<C> collectionFactory) {
    return map.values().stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toCollection(collectionFactory));
}