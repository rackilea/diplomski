private static <T extends Comparable<? super T>> void merge(List<T> a, int p, int q, int r) {
    int i, half = q - p;
    T[] left = new T[half];

    for (i = 0; i < half; i++)
        left[i] = a.get(p + i);

    for (i = 0; i < half; ) {
        if (q == r || left[i].compareTo(a.get(q)) <= 0)
            a.set(p++, left[i++]);
        else
            a.set(p++, a.get(q++));
    }
}