import java.util.Arrays;
import java.util.Scanner;

public class lalala {

    public static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.print("Input array: ");
        String n = input.nextLine();
        char[] x = n.toCharArray();
        int[] array = new int[x.length];
        for (int i = 0; i < x.length; i++) { //this is the loop i want to ask
            array[i] = Integer.parseInt(x[i] + "");
        }
        System.out.println(Arrays.toString(array));
    }
}