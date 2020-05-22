import java.util.Scanner;

public class ValidationOfNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        int[] inputRange = new int[3];
        int counter = 0;
        int number = 0;
        System.out.println("Enter 3 digits between 1-9"); //Ask for digits, numbers can have multiple digits, while digits are numbers from 0-9
        for (int i = 0; i < inputRange.length; i++) {
            valid = false; //Restart "valid" variable for each new user input
            do {
                number = in.nextInt();
                if (number >= 1 && number <= 9) {
                    valid = true; //If valid, it will exit do-while
                } else {
                    System.out.println("Enter a valid digit between 1-9");
                }
            } while (!valid);
            inputRange[i] = number; //We know it's valid because it went out of do-while, so we can now store it in the array
        }

        for (int i = 0; i < inputRange.length; i++) {
            System.out.println(inputRange[i]);
        }
    }
}