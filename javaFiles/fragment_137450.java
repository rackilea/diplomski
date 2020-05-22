private static <T, R extends Comparable<? super R>> boolean isSorted(List<T> list, Function<T, R> f) {
    Comparator<T> comp = Comparator.comparing(f);
    for (int i = 0; i < list.size() - 1; ++i) {
        T left = list.get(i);
        T right = list.get(i + 1);
        if (comp.compare(left, right) >= 0) {
            return false;
        }
    }

    return true;
}