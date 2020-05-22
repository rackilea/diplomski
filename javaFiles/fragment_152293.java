import java.util.Scanner;

public class Pr8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers do you wish to enter?  ");
        while (!scanner.hasNextInt()) {
            System.err.print("Again, how many numbers?  ");
            scanner.next();
        }
        int numberCount = scanner.nextInt();
        int[] numbers = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            String numberString;
            System.out.print("Please enter string #" + (i + 1) + " containing a number:  ");
            scanner.nextLine();
            while ((numberString = scanner.findInLine("[+-]?[0-9]+")) == null) {
                System.err.print("Again, string #" + (i + 1) + " should contain a number:  ");
                scanner.nextLine();
            }
            numbers[i] = Integer.parseInt(numberString);
            System.out.println("Number #" + (i + 1) + " found = " + numbers[i]);
        }
    }
}