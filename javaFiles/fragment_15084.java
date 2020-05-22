import java.util.Scanner;

public class Main {
    final static int NUM = 10;

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        final int[] list = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            System.out.println("Enter an integer");
            list[i] = scan.nextInt();
        }
        printIt(list);
    }

    public static void printIt(int[] list) {
        final int length = list.length;
        int total = 0;
        for (int i = 0; i < length; i++) {
            final int n = list[i];
            System.out.println(n);
            total += n;
        }
        System.out.println("Average: " + (double)total / length);
    }
}