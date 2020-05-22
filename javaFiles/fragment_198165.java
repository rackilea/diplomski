import java.util.Scanner;

public class BatmanBarGraph
{
    public static void main(String[] args)
    {
        System.out.println("Good Morning Lucius. Enter Transfers - ");
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Transfer 1: ");
        int transfer1 = keyboard.nextInt();
        System.out.print("Transfer 2: ");
        int transfer2 = keyboard.nextInt();

        System.out.println();
        System.out.println("Suspicious transfer chart:");

        System.out.print("Transfer 1: ");
        for (int n = transfer1 / 100; n > 0; n--) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("Transfer 2: ");
        for (int n = transfer2 / 100; n > 0; n--) {
            System.out.print("*");
        }
        System.out.println();

    }
}