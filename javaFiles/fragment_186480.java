static <T extends Comparable<? super T>> void sort(int k, List<T> list) {
    sort(k, list, null);
}

static <T> void sort(int k, List<T> list, Comparator<? super T> comp) {
    int size = list.size();
    for (int i = 0; i < size; i += k) {
        Collections.sort(list.subList(i, Math.min(i + k, size)), comp);
    }
}