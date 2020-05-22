public static <T, K extends Comparable<K>> void sort(List<T> data, 
                                                     Function<? super T, K> map) {
    @SuppressWarnings("unchecked")
    T[] array = (T[]) data.toArray();
    // Comparator.comparing appeared in Java-8
    quickSort(array, Comparator.comparing(map));
    for(int i=0; i<array.length; i++) {
        data.set(i, array[i]);
    }
}