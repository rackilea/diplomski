private static int f(int[] arr, int size) {
    if (size <= 1) return 0; // there can't be duplicates if there are not even 2 elements!
    return f(arr, size - 1) + (inArray(arr, size - 1, arr[size - 1]) ? 1 : 0);
}

private static boolean inArray(int[] arr, int size, int elem) {
    if (size == 0) return false;
    return arr[size - 1] == elem || inArray(arr, size - 1, elem);
}