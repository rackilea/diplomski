private static int comparisions = 0;

public static int binarySearch(double[] arr, double x, int high, int low) {
    int mid = (high + low) / 2;
    if (high == low || low == mid || high == mid) {
        comparisions++;
        return -1;
    }
    if (arr[mid] < x) {
        comparisions++;
        return binarySearch(arr, x, high, mid);
    } else if (arr[mid] > x) {
        comparisions++;
        return binarySearch(arr, x, mid, low);
    } else if (arr[mid] == x) {
        comparisions++;
        return mid;
    }
    return -1;
}

public static void main(String args[]) {
    int n = 1000;
    double array[] = new double[n];
    for (int i = 0; i < 100; i++) {
        for (int k = 0; k < n; k++) {
            double r = Math.random();
            r = r * 100;
            r = Math.round(r);
            r = r / 100;
            array[k] = r;
        }
        Arrays.sort(array);
        double search = Math.random();
        search = search * 100;
        search = Math.round(search);
        search = search / 100;
        int result = binarySearch(array, search, n, 0);
        System.out.println("Number of comparisions " +  comparisions);
        if (result == -1)
            System.out.println(search + " befindet sich nicht im Array.");
        else
            System.out.println(search + " befindet sich im Array an der Stelle " + (result) + ".");
    }

}