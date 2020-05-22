import java.util.*;

/**
 *
 * @author Tyler Weaver
 */
public class Test {

    public static void main(String[] args) {
        System.out.print("Enter A Number: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int sumOfDivisors = 0;

        for (int number = 2; number <= input; number++) {
            System.out.printf("Number: %,d%n[", number);

            for (int divisor = 1; divisor < number; divisor++) {

                if (number % divisor == 0) {
                    sumOfDivisors += divisor;
                    System.out.printf("%,d, ", divisor);
                }
            }

            System.out.printf("\b\b]%n");

            if (sumOfDivisors == number) {
                System.out.printf("Therefore %,d is a perfect number.%n%n",
                        number);
            } else {
                System.out.printf("%n");
            }

            sumOfDivisors = 0;
        }

        sc.close();
    }
}