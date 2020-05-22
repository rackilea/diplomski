Object received = in.readObject();
if (received instanceof int[]) {
    // received 1d array
    int[] array1D = (int[]) received;
} else if (received instanceof int[][]) {
    // received 2d array
    int[][] array2D = (int[][]) received;
}