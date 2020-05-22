import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] evens = getAllEvens1(arr);
        for (int i : evens) {
            System.out.print(i + " ");
        }
    }

    public static int[] getAllEvens1(int[] array) {
        int[] temp = new int[array.length]; // if all of array are `even`..
        Arrays.fill(temp, -1); //or any flag.. to indicate it's unnecessary

        int j = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                temp[j++] = i;
            }
        }

        int[] ret = new int[j];
        j = 0;
        for (int i : temp) {
            if (i != -1) {
                ret[j++] = i;
            }
        }
        return ret;

    }

    public static int[] getAllEvens(int[] array) {
        ArrayList<Integer> temp = new ArrayList();

        for (int i : array) {
            if (i % 2 == 0) {
                temp.add(i);
            }
        }
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}