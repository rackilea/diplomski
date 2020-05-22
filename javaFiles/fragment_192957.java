public class Search {
    public final static int NOT_FOUND = -1;

    public static double[] bubbleSort(double[] a) {
        int length = a.length;
        System.out.print("Original Order : ");
        for (int i = 0; i < length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println("\n");
        System.out.print("Ascending Order : ");
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - j; j++) {
                if (a[j] > a[j + 1]) {
                    double f = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = f;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
        return a;
    }

    public static int binarySearch(double[] a, double x) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] - x < 0)
                low = mid + 1;
            else if (a[mid] - x > 0)
                high = mid - 1;
            else {
                return mid;
            }
        }
        return NOT_FOUND;
    }

    public static void main(String[] args) {
        double[] array = { -3, 10, 5.0, 24, 45.3, 10.5 };
        double[] sortedArray = bubbleSort(array);
        System.out.println(binarySearch(sortedArray, 45.3));
    }
}