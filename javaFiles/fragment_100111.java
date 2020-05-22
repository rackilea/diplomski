import java.util.Scanner;

public class QuickTester {

    public static void main(String[] args) {

        double fahrenheit;
        Scanner input = new Scanner(System.in);

        // Validation
        while(true) {

            System.out.print("What is the temperature in Fahrenheit?: ");

            // If alphabetical characters are entered
            if (!input.hasNextDouble()) {
                System.out.println("Oops! " +
                        "Try entering only numerical characters.\n");

                // Clear away erroneous input
                input.nextLine();
            }
            else {

                fahrenheit = input.nextDouble();
                break; // Get out of while loop
            }
        }

        input.close();
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }
}