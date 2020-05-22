public static <T> List<List<T>> permutations(List<List<T>> lists) {
    return permutations(lists, new ArrayList<>());
}

private static <T> List<List<T>> permutations(List<List<T>> lists, List<T> prefix) {
    if (lists.isEmpty()) return Arrays.asList(prefix);

    List<T> head = lists.get(0);
    List<List<T>> tail = lists.subList(1, lists.size());

    List<List<T>> result = new ArrayList<>();
    for (T t : head) {
        List<T> p = new ArrayList<>(prefix);
        p.add(t);
        result.addAll(permutations(tail, p));
    }
    result.addAll(permutations(tail, prefix));
    return result;
}