import java.util.Arrays;

public class Fill {

    public static void main(String[] args) {
        int[] row = new int[5];
        int[][] arr = new int[5][];
        Arrays.fill(row, -1);
        Arrays.fill(arr, row);

        for (int[] r : arr) {
            for (int c : r) {
                System.out.print(c + "  ");
            }
            System.out.println();
        }

    }
}