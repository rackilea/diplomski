import java.util.Random;
import java.util.Scanner;

public class lottery {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] lotto = new int[6];
        int num;
        for (int i = 0; i < 6; i++) {
            num = (int) (Math.random() * 49 + 1);
            for (int j = 0; j < i; j++) {
                if (lotto[j] == num) {
                    num = (int) (Math.random() * 49 + 1);
                }
            }
            lotto[i] = num;
        }
        int count = checkTicket(lotto);
        System.out.println("The lottery numbers:");
        System.out.println("--------------");
        for (int i = 0; i < lotto.length; i++) {
            System.out.print(lotto[i] + " ");
        }
        System.out.println("\n--------------");

        if (count > 3) {
            System.out.println("You have the winning ticket and this was the number of matches: " + count);
        } else
            System.out.println("Better luck next time! This was how many you got right: " + count);
    }

    public static int checkTicket(int[] lotto) {
        System.out.println("Enter 6 numbers between 1 to 49");
        Scanner kb = new Scanner(System.in);
        int count = 0;
        int[] user = new int[6];

        for (int i = 0; i < user.length; i++) {
            System.out.print("Number: ");
            user[i] = kb.nextInt();
            for (int j = 0; j < lotto.length; j++) {
                if (user[i] == lotto[j])
                    count++;
            }
        }
        return count;
    }
}