public static void main(String[] args) {
    List<Integer> list = Arrays.asList(2, 3, 2, 5, 6, 1, -2, 3, 14, 12);
    quickSort(list, 0, list.size() - 1);
    System.out.println(list);
}

private static void quickSort(List<Integer> list, int first, int last) {
    if (last - first > 0) {
        int pivot = pivot(list, first, last);
        int index = partition(list, first, last, pivot);
        quickSort(list, first, index - 1);
        quickSort(list, index + 1, last);
    }
}

private static int pivot(List<Integer> list, int first, int last) {
    return ((last - first) / 2) + first;
}

private static int partition(List<Integer> list, int first, int last, int pivot) {
    Collections.swap(list, last, pivot);
    int j = first;
    for (int i = first; i < last; i++) {
        if (list.get(i) <= list.get(last)) {
            Collections.swap(list, i, j);
            j++;
        }
    }
    Collections.swap(list, last, j);
    return j;
}