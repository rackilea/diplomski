import java.util.Arrays;

public class CartesianProduct {
    public static void main(String[] args) {
        printAll(5, 3, 4, 6);
    }

    public static void printAll(int... maxes) {
        int[] current = new int[maxes.length];
        printAll(maxes, current, 0);
    }

    private static void printAll(int[] maxes, int[] current, int i) {
        if(i == current.length) {
            System.out.println(Arrays.toString(current));
        } else {
            int max = maxes[i];
            for(int j = 0; j <= max; ++j) {
                current[i] = j;
                printAll(maxes, current, i+1);
            }
        }
    }
}