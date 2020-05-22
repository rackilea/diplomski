public static void swap(List<Integer> sort, int i, int j) {
    int tmp = sort.get(i);
    sort.set(i, sort.get(j));
    sort.set(j, tmp);
}

public static void doSort(List<Integer> sort) {
    int min;
    for (int i = 0; i < sort.size(); ++i) {
        //find minimum in the rest of array
        min = i;
        for (int j = i + 1; j < sort.size(); ++j) {
            if (sort.get(j) < sort.get(min)) {
                min = j;
            }
        }

        //do swap
        swap(sort, i, min);
    }
}