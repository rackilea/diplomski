import java.util.Scanner;

public class LargestDiff {

    public static void main(String[] args) {
        final int days = 10;
        Scanner sc = new Scanner(System.in);

        int largeDiff = calculateLargestDiff(sc, days);

        System.out.println(largeDiff);
        sc.close(); //don't forget to close scanner
    }

    public static int calculateLargestDiff(Scanner sc, int days){
        int largeDiff = 0;
        System.out.println("Enter a stock price for day 1");

        int price1 = sc.nextInt();

        for (int i = 2; i <= days; i++) {
            System.out.println("Enter a stock price for day "+i);
            int price2 = sc.nextInt();

            int diff2 = Math.abs(price1 - price2);
            price1 = price2;

            if (diff2 > largeDiff) {
                largeDiff = diff2;
            }
        }
        return largeDiff;
    }
}