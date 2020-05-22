import java.io.*;

public class CharacterStretcher {

    public static void main(String[] args) {

        //Assumes the input is at c:\data.txt
        File inputFile = new File("c:\\data.txt");
        //Assumes the output is at c:\temp.txt
        File outputFile = new File("c:\\temp.txt");
        try {
            //Construct a file reader and writer
            final FileInputStream fstream = new FileInputStream(inputFile);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            final BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, false));

            //Read the file line by line...
            String line;
            while ((line = reader.readLine()) != null) {
                //Create a StringBuilder to build our modified lines that will
                //go into the output file
                StringBuilder newLine = new StringBuilder();

                //Split each line from the input file by spaces
                String[] parts = line.split(" ");

                //For each part of the input line, check if it's a number
                for (String part : parts) {
                    try {
                        //If we can parse the part as an integer, we assume
                        //it's a number because it almost certainly is!
                        int number = Integer.parseInt(part);
                        //We add this to out new line, but multiply it by 4
                        newLine.append(String.valueOf(number * 4));
                    } catch (NumberFormatException nfEx) {
                        //If we couldn't parse it as an integer, we just add it
                        //to the new line - it's going to be a String.
                        newLine.append(part);
                    }

                    //Add a space between each part on the new line
                    newLine.append(" ");
                }
                //Write the new line to the output file remembering to chop the
                //trailing space off the end, and remembering to add the line
                //breaks
                writer.append(newLine.toString().substring(0, newLine.toString().length() - 1) + "\r\n");
                writer.flush();
            }

            //Close the file handles.
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}