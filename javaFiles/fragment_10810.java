import java.util.Arrays;
public class Unique {
public static void main(String[] args) {
    int[] numbers = {
        1,
        6,
        2,
        14,
        6,
        8,
        2,
        1,
        23
    };
    System.out.println(numUnique(numbers));
}

public static int numUnique(int[] array) {
    Arrays.sort(array);
    int dups = 0;
    for (int i = 1; i < array.length; i++) {
        if (array[i] == array[i - 1]) {
            dups++;
        }
    }
    return (array.length - dups);
}
}