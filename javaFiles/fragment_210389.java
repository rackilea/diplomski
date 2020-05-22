import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long sum = 0;
        long num1 = 0;
        long num2 = 0;
        char s = ' ';
        String answer = "yes";

        while (true) {
            border();
            System.out.println("Acara's Calculator™ V_.01");

            System.out.println("What operation would you like to do?");
            System.out.println("Press '+' for addition, '-' for subtraction, '/' for division or '*' for multiplication and 'q' for quit.");
            s = in.next().charAt(0);
            if (s == 'q') {
                break;
            }

            border();
            System.out.println("What is your first number? ");
            num1 = in.nextInt();

            System.out.println("What is your second number? ");
            num2 = in.nextInt();

            if (s == '/') {
                sum = num1 / num2;
                System.out.println("Your answer is : " + sum);
            } else if (s == '*') {
                sum = num1 * num2;
                System.out.println("Your answer is : " + sum);
            } else if (s == '+') {
                sum = num1 + num2;
                System.out.println("Your answer is : " + sum);
            } else if (s == '-') {
                sum = num1 - num2;
                System.out.println("Your answer is : " + sum);
            }

            border();

        }
    }

    public static void border() {
        System.out.println("***** ***** ***** ***** ***** ***** ***** ***** ***** *****");
    }

}