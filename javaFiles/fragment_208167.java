static double[] array_product(double[] a, double[] b) {
    int n = a.length - b.length + 1;
    double[] result = new double[n];

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < b.length; ++j) {
            result[i] += a[i + j] * b[j];
        }
    }

    return result;
}

public static void main(String[] args) {
    double[] array1 = new double[]  {1, 2, 3, 4};
    double[] array2 = new double[] {10, 20};
    double[] result = array_product(array1, array2);

    System.out.print(Arrays.toString(result));
}