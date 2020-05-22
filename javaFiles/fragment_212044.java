import java.util.Arrays;

public class Main {
    private int[] original = new int[] {1, 3, 5, 7, 9}; // original array
    private int[] random = new int[] {1, 2, 3, 4, 5, 6}; // missing value from original array will be printed

    public static void main(String[] args) {
        Main m = new Main();
        Arrays.sort(m.original); // sort is required for binarySearch()
        for (int i : m.random) {
            if (Arrays.binarySearch(m.original, i) < 0)
                System.out.println(i);
        }
    }
}