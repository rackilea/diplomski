public static <T, K extends Comparable<K>> void sort(List<T> data, 
                                                     Function<? super T, K> map) {
    @SuppressWarnings("unchecked")
    ComparableValue<T, K>[] a = new ComparableValue[data.size()];
    int i=0;
    for(T element : data) {
        a[i++] = new ComparableValue<>(map.apply(element), element);
    }
    quickSort(a);
    for(i=0; i<a.length; i++) {
        data.set(i, a[i].origValue);
    }
}