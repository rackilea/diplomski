private static <T extends Comparable<? super T>> ArrayList<T> selection_sort(
            ArrayList<T> arr) {
    for (int i = 0; i < arr.size(); i++) {
        int pos = i;

        for (int j = i; j < arr.size(); j++) {
            if (arr.get(j).compareTo(arr.get(pos)) < 0)
                pos = j;
        }

        T min = arr.get(pos);
        arr.set(pos, arr.get(i));
        arr.set(i, min);
    }
    return arr;
}