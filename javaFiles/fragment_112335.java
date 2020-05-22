void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
}


void permute(int[] arr) {
    permute(arr, 0, arr.length - 1);
}


void permute(int[] arr, int i, int n) {
    int j;
    if (i == n)
        System.out.println(Arrays.toString(arr));
    else {
        for (j = i; j <= n; j++) {
            swap(arr, i, j);
            permute(arr, i + 1, n);
            swap(arr, i, j); // backtrack
        }
    }
}