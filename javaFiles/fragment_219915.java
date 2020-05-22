public static <T> List<T> merge(List<T> l1, List<T> l2, int r1, int r2) {
    List<T> result = new ArrayList<T>();

    int index1 = 0;
    int index2 = 0;

    while (index1 < l1.size() || index2 < l2.size()) {
        for (int i = 0; i < r1; ++i)
            result.add(l1.get((index1 + i) % l1.size()));
        index1 += r1;
        if (index2 < l2.size()) {
            for (int i = 0; i < r2; ++i)
                result.add(l2.get((index2 + i) % l2.size()));
            index2 += r2;
        }

    }
    return result;
}