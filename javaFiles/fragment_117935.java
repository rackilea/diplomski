import java.util.Arrays;
import java.util.Scanner;

public class lalala {

    public static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.print("Input array: ");
        String n = input.nextLine();            //1234
        String[] x = n.split("");               //[,1,2,3,4]
        int[] array = new int[x.length - 1];    // size = 4
        for (int i = 1; i < x.length; i++) {
            array[i - 1] = Integer.parseInt(x[i]);
        }
        System.out.println(Arrays.toString(array));
    }
}