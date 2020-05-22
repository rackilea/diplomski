public static void merge(int[] B, int begin, int middle, int end, int[] A) {
    System.arraycopy(A, begin, B, begin, end - begin);
    int i = begin;
    int j = middle;
    for (int k = begin; k < end; k++) {
        if (i < middle && (j >= end || B[i] <= B[j])) {
            A[k] = B[i];
            i = i + 1;
        } else {
            A[k] = B[j];
            j = j + 1;
        }
    }
}