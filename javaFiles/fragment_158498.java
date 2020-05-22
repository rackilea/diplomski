import java.util.Scanner;

public class MastremindString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // print welcome, what 4 digit number do you guess...
        System.out.println("Welcome to Mastermind.");
        System.out
                .println("I have a 4 digit number in mind. Can you guess it?");
        System.out.println("");
        System.out.println("What is your guess?");
        // string guess is number that is scanned
        String guess = input.nextLine();
        String validNumber = generateValidNumber();
        System.out.print("Perfect matches: "
                + perfectMatches(guess, validNumber));
        System.out.println("off place: " + offPlaceMatches(guess, validNumber));

        while (!(perfectMatches(guess, validNumber) == 4)) {
            System.out.println("");
            System.out.println("What is your guess?");
            guess = input.nextLine();
            System.out.print("Perfect matches: "
                    + perfectMatches(guess, validNumber));
            System.out.println("off place: "
                    + offPlaceMatches(guess, validNumber));
        }

        System.out.println("Yes! You guessed my number correctly. Well done.");

    }

    static boolean isValidNumber(String number) {
        if (number.length() != 4) {
            return false;
        }
        char[] numberArray = new char[4];

        for (int i = 0; i < 4; i++) {
            numberArray[i] = number.charAt(i);
            if (!((number.charAt(i) <= '9') && (number.charAt(i) >= '0'))) {
                return false;
            }
        }

        for (int i = 0; i < 4; i++) {
            char c = numberArray[i];
            int count = 0;
            for (int j = 0; j < 4; j++)
                if (numberArray[j] == c)
                    count++;
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    static int perfectMatches(String one, String two) {
        int counter = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) == two.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }

    static int offPlaceMatches(String one, String two) {
        int counter = 0;
        for (int i = 0; i < one.length(); i++) {
            for (int j = 0; j < two.length(); j++) {
                if (one.charAt(j) == two.charAt(i) && i != j) {
                    counter++;
                }
            }
        }
        return counter;
    }

    static String generateValidNumber() {
        boolean validNumber = false;
        String newNumber = "";
        while (!validNumber) {
            newNumber = "";
            for (int i = 0; i < 4; i++) {
                char c = (char) ('0' + (Math.random() * 10));
                newNumber = newNumber + c;
            }
            if (isValidNumber(newNumber))
                validNumber = true;
        }
        return newNumber;
    }
}