static List<Integer> findSmallPrecedingValues(List<Integer> values) {
    return IntStream.range(0, values.size() - 1)
        .filter(i -> values.get(i) < values.get(i + 1))
        .mapToObj(values::get)
        .collect(Collectors.toList());
}