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
        Collection<Integer> col = new ArrayList<>();

        for (int number = 1; number <= input; number++) {
            for (int divisor = 1; divisor < number; divisor++) {

                if (number % divisor == 0) {
                    sumOfDivisors += divisor;
                    col.add(divisor);
                }
            }

            if (sumOfDivisors == number) {

                System.out.printf("Perfect Number: %,d%n[", number);
                for (Integer i : col) {
                    System.out.printf("%,d, ", i);
                }
                System.out.printf("\b\b]%n");
            }

            sumOfDivisors = 0;
            col.clear();
        }

        sc.close();
    }

}