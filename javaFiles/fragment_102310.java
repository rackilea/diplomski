import java.util.Arrays;
import java.util.Comparator;

public class Q1 {

    public static Object[] data = new Object[10];

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            int r = (int) (Math.random() * 100);
            System.out.print("Adding: " + r);
            sortInOrder(r);

            System.out.print("[");
            for (int j = 0; j < 10; j++)
                System.out.print(" " + data[j]);
            System.out.println(" ]");
        }

        System.out.print("[");
        for (int i = 0; i < 10; i++)
            System.out.print(" " + data[i]);
        System.out.print(" ]");
    }

    public static void sortInOrder(Integer x) {
        if (x == null)
            throw new IllegalArgumentException();

        int idx = Arrays.binarySearch(data, 0, data.length - 1, x, Comparator.nullsLast((Object o1, Object o2) -> ((Integer) o1) - ((Integer) o2)));

        if (idx < 0) idx = -idx - 1;
        System.out.println(" at index: " + idx);

        // Hint: Use arraycopy instead of for loop for better performance
        System.arraycopy(data, idx, data, idx + 1, data.length - 1 - idx);

        data[idx] = x;
    }

}