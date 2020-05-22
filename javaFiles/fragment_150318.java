public static <T, S> Map<T, List<Double>> method(
        Map<T, Map<S, Double>> map1,
        Map<T, Map<S, Double>> map2)
{
    Set<T> commonKeys = intersection(map1.keySet(), map2.keySet());

    return commonKeys.stream().collect(Collectors.toMap(
            Function.identity(),
            key -> {
                Map<S, Double> inner1 = map1.get(key);
                Map<S, Double> inner2 = map2.get(key);

                Set<S> innerCommonKeys = intersection(
                        inner1.keySet(),
                        inner2.keySet());

                        return innerCommonKeys.stream().map(innerKey ->
                                inner1.get(innerKey) - inner2.get(innerKey))
                                .collect(Collectors.toList());
            }));
}

private static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
    Set<T> intersection = new HashSet<T>(set1);
    intersection.retainAll(set2);
    return intersection;
}