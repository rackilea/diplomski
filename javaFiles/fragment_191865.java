static int maxString(String[] arr) {
    int max = sumString(arr[0]);
    for (int i = 1; i < arr.length; i++) {
        max = Math.max(max, sumString(arr[i]));
    }
    return max;
}