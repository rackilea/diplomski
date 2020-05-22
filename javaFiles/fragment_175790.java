public int[] leftRotate(int[] arr, int n, int d) {

    int rot = 0;
    int[] marr = new int[n];
    if (d < 0 || d == 0 || d>n) {
        return arr;
    }

    else {
        for (int i = 0; i < n; i++) {

            if (i < n - d) {
                marr[i] = arr[i + d];
            } else {
                marr[i] = arr[rot];
                rot++;
            }

        }

        return marr;
    }

}

    public void GetArray(int[] arr, int n, int d) {

    int[] arr1 = leftRotate(arr, n, d);
    for (int j : arr1) {
        System.out.println(j);
    }
}

    public static void main(String args[]) {

    int[] arr = { 1,2,3,4,5 };
    int n = arr.length;

    Test2 obj = new Test2();
    obj.GetArray(arr, n, 2);

}