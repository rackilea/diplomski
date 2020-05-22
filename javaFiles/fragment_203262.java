public static <T> ArrayList<T> merge(List<T> a, List<T> b) {
    ArrayList<T> result = new ArrayList<T>();
    int size = Math.max(a.size(), b.size());

    for (int i = 0; i < size; i++) {
        if (i < a.size()) result.add(a.get(i));
        if (i < b.size()) result.add(b.get(i));
    }
    return result;
}