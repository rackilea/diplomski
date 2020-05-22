import java.util.Scanner;
public class MathOperations {
    public static void main(String[] args){
        int firstNumber = 0;
        int secondNumber = 0;
        char operator;
        double answer = 0.0;

        Scanner scanObject = new Scanner(System.in);

        System.out.println("Please enter your first number: ");
        firstNumber = scanObject.nextInt();
        System.out.println("Please enter your second number");
        secondNumber = scanObject.nextInt();
        System.out.println("Addition, substraction, multiplcation, or dividing? ");
        operator = scanObject.next().charAt(0);

        switch (operator){
            case 'A': answer = firstNumber + secondNumber;
        }
    }

}