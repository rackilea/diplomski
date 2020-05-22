import java.util.Scanner;

class Chiffrator {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in); // Initializing keyboard
                                                // scanner, like arrays (Scanner
                                                // [name] = new
                                                // Scanner(System.in)

        String initial_code; // Initializing the string into which the text will
                                // be entered
        System.out.println("Enter initial code: ");
        initial_code = input.next(); // Initializing input process, with syntax
                                        // [string_name] = [scanner_name].next()

        char letters[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
        int[] numbers = new int[9];
        int i, j, k;

        for (i = 0; i <= 9; i++) {
            numbers[i] = i;
            i++;
        }

        for (k = 0; k <= initial_code.length(); k++) { // .length() is a method!
            if (initial_code.contains(numbers.toString()))
                numbers[k] = letters[k];
            else if (initial_code.contains(letters.toString()))
                letters[k] = (char) numbers[k];
            k++;
        }

        System.out.println("Your chiffred code is " + initial_code);
    }
}