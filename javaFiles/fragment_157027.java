public static void main(String[] args) {
    List<? extends Number> l1 = Arrays.asList(1L, 2, 3L);
    List<? extends Number> l2 = Arrays.asList(1);
    isEqual(l1, l2);
}

public static <U, V> boolean isEqual(List<U> a, List<V> b) {
    // is U == V here?
}