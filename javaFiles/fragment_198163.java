import java.util.Scanner;

public class BatmanBarGraph {
    public static void main(String[] args)
    {
        System.out.println("Good Morning Lucius. Enter Transfers - ");
        Scanner keyboard = new Scanner(System.in);
        int[] transfers = new int[5];
        for (int i = 0; i < transfers.length; i++) {
            System.out.print("Transfer " + (i + 1) + ": ");
            transfers[i] = keyboard.nextInt();
        }
        System.out.println();
        System.out.println("Suspicious transfer chart:");
        for (int i = 0; i < transfers.length; i++) {
            System.out.print("Transfer " + (i + 1) + ": ");
            for (int n = transfers[i] / 100; n > 0; n--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}