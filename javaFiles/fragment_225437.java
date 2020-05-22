package stackManca;

import java.util.Scanner;

public class KarmaKing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = null;
        int inputNumber = 0;
        while (scan.hasNextLine()) {
            input = scan.next();
            try {
                inputNumber = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Please enter a number");
                continue;
            }
            if (input.length() != 2) {
                System.out.println("Please Enter a 2 digit number");
            } else {
                System.out.println("You entered: " + input);
            }
        }
    }
}