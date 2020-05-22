private static int[] copyOfRange(int[] arr, int start, int end) {
    int pos = 0;
    int[] out = new int[end - start];
    for (int i = start; i < end; i++) {
        out[pos] = arr[i];
        pos++;
    }
    return out;
}