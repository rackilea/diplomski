private static <T extends Comparable<? super T>> T median(T a, T b, T c) {
    List<T> medianHelper = Arrays.asList(a, b, c);

    Collections.sort(medianHelper);

    return medianHelper.get(1);
}