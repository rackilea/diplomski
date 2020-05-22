import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Out of 10, how much do you love me?");
        int input = 0
        while (input <= 9) {
            input = scanner.nextInt();
            if (input <= 9) {
                System.out.println("Wrong answer");
            } else {
                System.out.println("Good answer");
            }
        }
    }
}