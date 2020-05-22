public static int longestSharedSequence(int[] arr, int[] arr2) {
    int maxN = 0;
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr2.length; j++) {
            int n = 0;
            // Check that elements match and that they are either the
            // first element in the sequence that is currently being
            // compared or that they are 1 greater than the previous
            // element
            while (arr[i + n] == arr2[j + n]
                    && (n == 0 || arr[i + n] == arr[i + n - 1] + 1)) {
                n++;
                if (i + n >= arr.length || j + n >= arr2.length) {
                    break;
                }
            }

            // If we found a longer sequence than the previous longest,
            // update maxN
            if (n > maxN) {
                maxN = n;
            }
        }
    }
    return maxN;
}