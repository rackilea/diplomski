import java.util.Scanner;
import java.util.InputMismatchException;

public class TestIO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstDouble = 0L;
        double secondDouble = 0L;
        while (true) {  // take input (two doubles) until successful
            System.out.println("Print two doubles (press enter after each input):");
            try {
                firstDouble = scanner.nextDouble();
                secondDouble = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input. You must print doubles.\n" +
                                   "Depending on your locale, as a decimal separator " +
                                   "use either a comma or a dot.\n");
                scanner.nextLine(); // clearing the buffer with the wrong input
                                    // to avoid infinite loop
                continue;
            }
            break; 
        }
        // Printing the user input (limiting doubles to 3 decimal places)
        System.out.format("You have printed %.3f and %.3f %n", 
                          firstDouble, secondDouble);
    }
}