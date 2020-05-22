package so_q33405148;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //TIP: You can use 'Scanner' instead of a 'Reader' here, to avoid having to parse strings into ints (scanner can do it for you)
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("How many numbers would you like to enter?");
            int count = Integer.parseInt(br.readLine());
            int input[] = new int[count];
            for (int i = 0; i < count; i++) {
                System.out.print("Enter a number to be sorted: ");
                //TIP: With some clever math, you can invert the array right as it's still filling up here, by manipulating a new int (so 'i' is unchanged, as it's the for-loop's index) using 'i' and 'input.length'...Or, with a little creativity and insight, you may even achieve the same result manipulating 'i' directly somewhere else...
                input[i] = Integer.parseInt(br.readLine());
            }

            System.out.println("Original array:\n" + Arrays.toString(input));

            //TIP: Better methods to reverse arrays and/or collections exist.
            //Take a look at SO question #3962766 (puritan solution without as much memory-footprint) and also Google about 'Arrays.asList()' and 'Collections.reverse()' (learn about collections-sorting)
            int reversedInput[] = new int[input.length];
            for (int i = 0; i < count; i++) {
                reversedInput[i] = input[count - i - 1];
            }

            System.out.println("Reversed array:\n" + Arrays.toString(reversedInput));
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}