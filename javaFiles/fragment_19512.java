import java.util.Scanner;
import java.io.*;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        File inputFile = new File("InputFile.txt");
        File outputFile = new File("OutputFile.txt");
        Scanner inFS = new Scanner(inputFile);
        PrintWriter outFS = new PrintWriter(outputFile);

        String line;
        while (inFS.hasNextLine()) 
        {   
            // Read in the line and convert it to upper case
            line = inFS.nextLine().toUpperCase();

            // Print the result to the console
            System.out.println(line);

            // Write the read in line to the output file with a new line character
            outFS.print(line + "\n");
        }

        // Close any resources used
        outFS.close();
        inFS.close();
    }
}