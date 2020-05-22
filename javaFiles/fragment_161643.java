public static int min(List<Integer> t) {
    if (t.size() < 2) {
        return t.get(0);
    }
    return Math.min(t.get(0), min(t.subList(1, t.size())));
}