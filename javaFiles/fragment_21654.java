import java.util.Arrays;

public class Test {
 public static void main(String[] args) {
    int[][] x = {{23, 33, 46, 50, 56},
            {3, 8, 65, 34, 90},
            {2, 7, 46, 50, 56}};

    int[] y = {2, 7, 46, 50, 56};

    for (int[] aX : x) {

        System.out.println(Arrays.toString(x[2]));

        if (Arrays.equals(aX, y)) {
            System.out.println("match");

        } else {
            System.out.println("no match");
        }
    }
  }
}