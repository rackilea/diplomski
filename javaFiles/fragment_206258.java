public static int[] NonZeros(int[] A) {
    int count = 0;
    for (int i = 0; i < A.length; i++) {
        if (A[i] != 0) {
            count++;
        }
    }
    int[] temp = new int[count];
    int p = 0;
    for (int i = 0; i < A.length; i++) {
        if (A[i] != 0) {
            temp[p++] = A[i];
        }
    }
    return temp;
}