private static void sort(int[][] a, int n, int c) {
    int key, j;
    for (int i = 1; i < n; i++){
        key = a[i][c];
        int[] keyRow = a[i];
        j = i - 1;
        while ((j >= 0) && (a[j][c] > key)){
            //a[j+1][c] = a[j][c];
            a[j+1] = a[j];
            j = j - 1;
        }
        //a[j+1][c] = key;
        a[j+1] = keyRow;
    }
}