import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nRolls = 100, nDice = 6; // default values

        Scanner in = new Scanner(System.in);
        System.out.print("Number of throws: ");
        nRolls = in.nextInt();
        System.out.print("Number of sides on the dices: ");
        nDice = in.nextInt();

        int minSum = 2, maxSum = 2 * nDice;
        int[] hist = new int[maxSum - minSum + 1];

        Random rand = new Random();
        for (int iter = 1; iter <= nRolls; iter++) {
            int throw1 = 1 + rand.nextInt(nDice), throw2 = 1 + rand.nextInt(nDice);
            int sum = throw1 + throw2;
            hist[sum - minSum]++;
        }

        System.out.println("Number of rolls: " + nRolls);
        System.out.println("Number of sides of the dice: " + nDice);
        System.out.println("Sum of Dice         Percentage");
        for (int i = 0; i < hist.length; i++) {
            System.out.println(String.format("   %2d                 %5.2f%%", i + minSum, hist[i] * 100.0 / nRolls));
            // System.out.println("   " + (i+minSum) + "             " + (hist[i]*100.0/nRolls);
        }

        in.close();
    }
}