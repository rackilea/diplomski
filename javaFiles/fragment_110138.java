import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
This program reads a file with numbers, and writes the numbers to another
file, lined up in a column and followed by their total.
*/
class FileClass{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Prompt for the input and output file names

        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();

        // Construct the Scanner and PrintWriter objects for reading and writing

        File inputFile = new File(inputFileName);
        Scanner in;
        try {
            in = new Scanner(inputFile);
            in.useDelimiter(""); // To recognize spaces in the text
            PrintWriter out = new PrintWriter(outputFileName);
            // Read the input and write the output
            String s = "";
            StringBuffer sb = new StringBuffer(s);
            while (in.hasNext())
            {
             String input = in.next();
             sb.append(input);
            }
             sb.reverse();
            //out.printf(sb);

            BufferedWriter bwr = new BufferedWriter(out);
            // To a String.
            String tmp = sb.toString();
            bwr.write(tmp.toCharArray());

            bwr.flush();
            bwr.close();

            in.close();
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        console.close();
    }
}