public static void recDfs(int[] arr, int k, int sum) {
    if (sum < 0) return;

    if (sum == 0) {
        counter++;
        return;
    }
    if (k == 0) {
        return;
    }

    recDfs(arr, k - 1, sum - arr[k - 1]);
    recDfs(arr, k - 1, sum);
}