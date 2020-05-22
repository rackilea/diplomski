public class ShiftTwoDArray {

    public static void main(String[] args) {
        int[][] x = {   { 1, 2, 3, 4, 5, 6, 7 }, 
                        { 1, 2, 3, 4, 5, 6, 7 }, 
                        { 1, 2, 3, 4, 5, 6, 7 },
                        { 1, 2, 3, 4, 5, 6, 7 } 
                    };

        int index = 3;
        int i, j;
        // System.out.println(x.length);
        System.out.println("Before");
        for (i = 0; i < x.length; i++) {
            for (j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "  ");
            }
            System.out.println();
        }
        rotate(x, index);

        System.out.println("\nAfter");
        for (i = 0; i < x.length; i++) {
            for (j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * @param x
     * @param index
     * calls rotateUtil on each row
     */
    private static void rotate(int[][] x, int index) {
        for (int i = 0; i < x.length; i++) {
            rotateUtil(x[i], index);
        }
    }

    /**
     * @param x
     * @param index
     * reverse array in parts and then reverse whole array
     */
    private static void rotateUtil(int[] x, int index) {
        reverse(x, 0, index);
        reverse(x, index + 1, x.length - 1);
        reverse(x, 0, x.length - 1);
    }

    /**
     * @param x
     * @param start
     * @param end
     * reverse an array
     */
    private static void reverse(int[] x, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = x[start];
            x[start] = x[end];
            x[end] = temp;
            start++;
            end--;
        }
    }
}