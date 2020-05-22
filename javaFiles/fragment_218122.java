static <T extends Comparable<T>> T Max(T[] arr) {
    T current = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i].compareTo(current) > 0) {
            current = arr[i];
        }
    }
    return current;
}