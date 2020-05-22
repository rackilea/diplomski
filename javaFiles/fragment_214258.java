public static <T> Map<T, Integer> findPairs(List<T> elements) {
    Set<T> tracked = new HashSet<>();
    Map<T, Integer> result = new HashMap<>();
    for (T element : elements)
        if (!tracked.add(element)) {
            result.merge(element, 1, Math::addExact);
            tracked.remove(element);
        }
    return result;
}