static <T, U> Map<T, Set<U>> groupSecondByFirst(Collection<Tuple<T, U>> tuples) {
    return tuples
        .stream()
        .collect(
            Collectors.groupingBy(
                Tuple::getFirst,
                Collectors.mapping(
                    Tuple::getSecond,
                    Collectors.toSet())));
}