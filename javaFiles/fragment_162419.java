public <A, B, C> Map<B, List<C>> groupsByInnerKey(Map<A, Map<B, C>> input) {
    return input.values()
            .stream()
            .flatMap(it -> it.entrySet().stream())
            .collect(Collectors.groupingBy(
                 Map.Entry::getKey,
                 Collectors.mapping(Map.Entry::getValue, Collectors.toList())
            ));
}