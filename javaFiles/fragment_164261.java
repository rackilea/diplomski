private int partition(List<Integer> arrayList, int left, int right) {

    int pivot = getPivot(arrayList, left, right);
    int i = left - 1; 

    for (int j = left; j < right; j++) {
        if (arrayList.get(j) <= pivot) {
            i++;
            Collections.swap(arrayList, j, i);
        }
    }

    Collections.swap(arrayList, i+1, right);
    return i+1;
}