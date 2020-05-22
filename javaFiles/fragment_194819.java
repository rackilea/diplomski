import java.util.Scanner;

public class circle {
    public static void main(String[] args) {
        String[] football_list = new String[100]; // Declare the array
        int counter = 0; // Initialize counter integer

        Scanner scanner = new Scanner(System.in); // Import Scanner
        System.out.println("Input as follows; "); // User instructions
        System.out.println("Home team : Away team : Home score : Away score");

        String line = null; // Creates a blank string

        while (!(line = scanner.nextLine()).equals("")) { // The code in the
                                                        // loop will process
                                                        // only if it is not
                                                        // empty

            if (line.equals("quit")) { // When the user is finished this exits
                                    // the program
                break;
            } else {
                football_list[counter] = line; // The below String is printed
                                            // for the amount of values
                                            // inside the counter integer

                System.out.println("Home team : Away team : Home score : Away score");
            }

            counter++; // counter is incremented
        }

        for (int i = 0; i < counter; i++) { // A loop to control the Array
            String[] words = football_list[i].split(":"); // Splits the input
                                                        // into 4 strings
            if (words.length != 4) {
                System.out.println("Input was not valid.");
            } else
                System.out.println(words[0].trim() + " [" + words[2].trim() + "]" + " | " + words[1].trim() + " ["
                    + words[3].trim() + "]"); // Formats and prints the output

        }

    }
}