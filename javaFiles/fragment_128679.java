public static boolean contains(int[] arr, int val) {
    for (int v : arr) {
        if (v == val) {
            return true;
        }
    }
    return false;
}