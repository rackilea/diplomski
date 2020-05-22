public static <T> List<T> alternate(final List<? extends T> list1, final List<? extends T> list2) {
    final int size = list1.size();
    if (list2.size() != size)
        throw new IllegalArgumentException();
    return new AbstractList<T>() {
        @Override
        public int size() {
            return 2 * size;
        }
        @Override
        public T get(int i) {
            return ((i & 1) == 0 ? list1 : list2).get(i >> 1);
        }
    };
}

public static void main(String[] args) {
    List<String> list1 = Arrays.asList("A", "B", "C");
    List<String> list2 = Arrays.asList("D", "E", "F");
    System.out.println(alternate(list1, list2));  // prints [A, D, B, E, C, F]
}