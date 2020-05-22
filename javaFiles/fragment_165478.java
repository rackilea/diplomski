public static boolean contains(List<int[][]> al, int[][] toFind) {
    for (int[][] arr : al) {
        if (Arrays.deepEquals(arr, toFind)) {
            return true;
        }
    }
    return false;
}