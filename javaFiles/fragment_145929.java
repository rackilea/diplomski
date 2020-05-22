import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {
        int size, i;
        sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to sort: ");
        size = sc.nextInt();

        int[] a = new int[size];

        System.out.print("Enter " + size + " numbers which should be sorted: \n");
        for (i = 0; i < size; i++) {
            try {
                a[i] = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                break;
            }
        }
        if (i == size) {
            Arrays.sort(a);

            System.out.println("\nAfter sorting:  ");
            for (int number : a) {
                System.out.print(number + "  ");
            }
        }
    }
}