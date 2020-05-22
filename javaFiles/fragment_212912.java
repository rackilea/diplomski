public static <T extends Comparable<? super T>> void sort(List<T> list) {
    mergesort(list, 0, list.size());
}   

private static <T extends Comparable<? super T>> void mergesort(List<T> list, int i, int j) {
    if (j - i < 2)
        return;
    int mid = (i + j) / 2;
    mergesort(list, i, mid);
    mergesort(list, mid, j);
    merge(list, i, mid, j);
}

private static <T extends Comparable<? super T>> void merge(List<T> a, int p, int q, int r) {
    int leftLen = q - p;
    int rightLen = r - q;

    List<T> left = new ArrayList<T>();
    List<T> right = new ArrayList<T>();

    for (int i = 0; i < leftLen; i++) {
        left.add(i, a.get(p + i));
    }
    for (int i = 0; i < rightLen; i++) {
        right.add(i, a.get(q + i));
    }

    int leftIndex = 0;
    int rightIndex = 0;
    int resultIndex = p;

    while (leftIndex < leftLen && rightIndex < rightLen) {
        if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
            a.set(resultIndex, left.get(leftIndex));
            resultIndex++;
            leftIndex++;
        } else {
            a.set(resultIndex, right.get(rightIndex));
            resultIndex++;
            rightIndex++;
        }
    }
    while (leftIndex < leftLen) {
        a.set(resultIndex, left.get(leftIndex));
        resultIndex++;
        leftIndex++;
    }
    while (rightIndex < rightLen) {
        a.set(resultIndex, right.get(rightIndex));
        resultIndex++;
        rightIndex++;
    }   
}