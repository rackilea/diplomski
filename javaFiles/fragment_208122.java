public static int lexicographically(List<Integer> a, List<Integer> b) {
    for (int i = 0, end = Math.min(a.size(), b.size()); i < end; i++) {
        int res = Integer.compare(a.get(i), b.get(i));
        if (res != 0)
            return res;
    }
    return Integer.compare(a.size(), b.size());
}