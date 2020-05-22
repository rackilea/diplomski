static int[] growArray(int[] data) {
    int size = 1;
    if (data != null) {
        size = 1 + data.length;
    }
    return new int[size];
}