private static <T extends Comparable<? super T>> void merge(List<T> a, int p, int q, int r) {
    int half = q - p;
    List<T> left = new ArrayList<T>();

    for (int i = 0; i < half; i++) {
        left.add(i, a.get(p + i));
    }

    int leftIndex = 0;
    int rightIndex = q;
    int resultIndex = p;

    while (leftIndex < half && rightIndex < r) {
        if (left.get(leftIndex).compareTo(a.get(rightIndex)) <= 0) {
            a.set(resultIndex, left.get(leftIndex));
            resultIndex++;
            leftIndex++;
        } else {
            a.set(resultIndex, a.get(rightIndex));
            resultIndex++;
            rightIndex++;
        }
    }
    while (leftIndex < half) {
        a.set(resultIndex, left.get(leftIndex));
        resultIndex++;
        leftIndex++;
    }
}