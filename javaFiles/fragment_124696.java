public class Main {
    public static void main(String[] args) {
        int n = 16;
        final int rows = 4;
        final int cols = 4;
        boolean reverse = false;

        for (int r = 1; r <= rows; ++r) {
            if (reverse) {
                for (int c = n - cols + 1; c <= n; ++c) {
                    System.out.print(c + " ");
                }

                n -= cols;
             } else {
                for (int c = 1; c <= cols; ++c, --n) {
                    System.out.print(n + " ");
                }
            }

            System.out.println();
            reverse = !reverse;
        }
    }
}