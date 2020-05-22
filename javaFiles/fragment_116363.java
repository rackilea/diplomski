import java.io.*;

public class ValidateTxtFile {

    private final int MAX_LINES_TO_READ = 5;

    private final String REGEX = ".{15}[ ]{5}.{15}[ ]{5}[-]\\d{2}\\.\\d{2}[ ]{9}\\d{2}/\\d{2}/\\d{4}";

    public void testFile(String fileName) {

        int lineCounter = 1;

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line = br.readLine();

            while ((line != null) && (lineCounter <= MAX_LINES_TO_READ)) {

                // Validate the line is formatted correctly based on regular expressions                
                if (line.matches(REGEX)) {
                    System.out.println("Line " + lineCounter + " formatted correctly");
                }
                else {
                    System.out.println("Invalid format on line " + lineCounter + " (" + line + ")");
                }

                line = br.readLine();
                lineCounter++;
            }

        } catch (Exception ex) {
            System.out.println("Exception occurred: " + ex.toString());
        }
    }

    public static void main(String args[]) {

        ValidateTxtFile vtf = new ValidateTxtFile();

        vtf.testFile("transactions.txt");
    }   
}