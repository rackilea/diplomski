public class hw21 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final double KEY = 0.0;
        final Double ACCEPTABLE_TOLERANCE = 0.000000000001d;

        int n = scan.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextDouble();
        }
        for (int k = 0, j = 0; k < n; k++) {
            if (Math.abs(a[k] - KEY) < ACCEPTABLE_TOLERANCE) {
                continue;
            }
            a[j] = a[k];
            System.out.println(a[j]);
            j++;
        }
    }
}