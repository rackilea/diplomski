public static List<Integer> merge(List<Integer> a, List<Integer> b) {
    final int aLen = a.size(), bLen = b.size();
    List<Integer> al = new ArrayList<>(aLen + bLen);
    int i = 0, j = 0;
    while (i < aLen && j < bLen) {
        if (a.get(i) < b.get(j)) {
            al.add(a.get(i++));
        } else {
            al.add(b.get(j++));
        }
    }
    while (i < aLen) {
        al.add(a.get(i++));
    }
    while (j < b.size()) {
        al.add(b.get(j++));
    }
    return al;
}