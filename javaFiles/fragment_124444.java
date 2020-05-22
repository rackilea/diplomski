public static void main(String[] args) {
    List<Integer> list = Arrays.asList(7, 2, 8, 1, 9, 5);
    System.out.println(max(Comparator.naturalOrder(), list));
}

// Not knowing Haskell at all, this is my guess at what foldl does.
private static <R, T> R foldl(BiFunction<R, T, R> f, R z, List<T> l) {
    for (T t : l)
        z = f.apply(z, t);
    return z;
}

private static <T> T max(Comparator<T> c, List<T> l) {
    if (l.isEmpty())
        throw new IllegalArgumentException();
    return foldl((t, u) -> c.compare(t, u) > 0 ? t : u, l.get(0), l);
}