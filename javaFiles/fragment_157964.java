public static int[] BubbleSortAsceMethod(int[] x) {
    for (int i = 1; i < x.length; i++) {
        boolean isSorted = true;

        for (int j = 0; j < x.length - i; j++) {
            if (x[j] > x[j + 1]) {
                int temp = x[j];
                x[j] = x[j + 1];
                x[j + 1] = temp;
                isSorted = false;
            }
        }
        if (isSorted) {
            break;
        }
    }
    return x;
}