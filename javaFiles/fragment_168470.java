import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Define new Scanner

        String answer = "yes";
        double finalValue;

        while (answer.equalsIgnoreCase("Yes")) {

            System.out.print("Enter First Number: ");
            Double firstNumber = null;
            while (firstNumber == null) {
                try {
                        firstNumber = Double.valueOf(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter number only.");
                }
            }

            System.out.print("Enter an operator (+, -, / or *): ");
            String line = null;
            while (line == null || line.length() == 0) {
                line = scanner.nextLine();
            }
            char operator = line.charAt(0);

            System.out.print("Enter Second Number: ");

            Double secondNumber = null;
            while (secondNumber == null) {
                try {
                        secondNumber = Double.valueOf(scanner.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter number only.");
                    secondNumber = null;
                    scanner.reset();
                }
            }

            switch(operator) {
                case '+':
                    finalValue = firstNumber + secondNumber;
                    System.out.println(finalValue);
                    break;
                case '-':
                    finalValue = firstNumber - secondNumber;
                    System.out.println(finalValue);
                    break;
                case '*':
                    finalValue = firstNumber * secondNumber;
                    System.out.println(finalValue);
                    break;
                case '/':
                    if(secondNumber == 0d) {
                        System.out.println("a number can not be divided by 0.");
                    } else {
                        finalValue = firstNumber / secondNumber;
                        System.out.println(finalValue);
                    }
                    break;
                default:
                    System.out.println("Operator entered incorrectly.");
                    break;
            }

            System.out.print("Do you want another operation? (type yes to continue): ");
            answer = scanner.next();

        }

        System.out.println("Bye.");


    }
}