public static <T> List<List<T>> permutations(List<List<T>> lists) {
    List<List<T>> result = new ArrayList<>();
    for (int i = 0; i <= lists.size(); i++) {
        result.addAll(permutations(lists, i));
    }
    return result;
}

private static <T> List<List<T>> permutations(List<List<T>> lists, int count) {
    if (count == 0) return Arrays.asList(new ArrayList<>());

    List<List<T>> result = new ArrayList<>();
    for (int i = 0; i < lists.size() - count + 1; i++) {
        for (T t : lists.get(i)) {
            for (List<T> r : permutations(lists.subList(i + 1, lists.size()), count - 1)) {
                r = new ArrayList<>(r);
                r.add(0, t);
                result.add(r);
            }
        }
    }
    return result;
}