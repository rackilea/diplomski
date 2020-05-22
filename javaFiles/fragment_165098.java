import java.util.*;
import java.io.*;

public class Duplicate {
    public static void main(String[] args) throws IOException {
        HashSet<String> uniqueNames = new HashSet<String>();
        ArrayList<String> outputLines = new ArrayList<String>();

        Scanner input = new Scanner(new File("input.txt"));
        while (input.hasNextLine()) {

            // Split a line into an array of names.
            String[] names = input.nextLine().split(" ");
            String edited = "";
            for (int i = 0; i < names.length; i++) {

                // If the name is already in the set, remove it.
                if (uniqueNames.add(names[i])) {
                    edited += names[i] + " ";
                }
            }

            edited = edited.strip();  // remove excess whitespace

            // Add the final line to our output array.
            if (!edited.equals("")) {
                outputLines.add(edited);
            }
        }

        // Write the output array to a file.
        String outputFn = "output.txt";
        BufferedWriter output = new BufferedWriter(new FileWriter(outputFn));
        output.write(String.join("\n", outputLines));
        output.close();
        System.out.println("File '" + outputFn + "' created!");
    }
}