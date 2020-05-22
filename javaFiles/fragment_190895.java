public class Arrays2 {
    public static void main(String[] args) {
        int[] a = {1, 4, 3, 5, 6};
        int[] b = {4, 1, 5, 3};
        findMissingNumber(a, b);
    }

    private static void findMissingNumber(int[] a, int[] b) {
        for (int n : a) {
            if (!isPresent(n, b)) {
                System.out.println("missing number: " + n);
                break;
            }
        }
    }

    private static boolean isPresent(int n, int[] b) {
        for (int i : b) {
            if (n == i) {
                return true;
            }
        }
        return false;
    }
}