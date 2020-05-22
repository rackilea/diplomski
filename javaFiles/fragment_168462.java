import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerInt {

    public static void main(String[] args) {
        // the main method is the first that is run.
        // the main method MUST be static
        // inside the main method put whatever you want to run in your program

        scan(); // we run the scanner method which is created below
    }

    public static void scan() {
            // first i create a scanner so that the java command prompt can take input
            Scanner input = new Scanner(System.in);

            System.out.println("Enter file path to file and file name: "); //prompt the reader to type the file directory and name
            File file = new File(input.nextLine()); // determine what file they want based on that name

            System.out.println("Enter the line you want to find: "); //prompt the reader to type the line they want to count
            String line = input.nextLine(); // determine what line they want based on that string

            // this statement tells them how many occurances there are
            // this is done by the countWord() method (which when run returns a integer)
            System.out.println("There are " + countWord(file, line) + " occurances.");

            System.exit(0); // ends the program
    }

    // the countWord method takes a file name and word to search and returns an integer
    public static int countWord(File dataFile, String WordToSearch) {

        int count = 0; // start are counter

        // NOTE: i prefer a BufferedReader to a Scanner you can change this if you want

        // load the buffered reader
        BufferedReader FileInput = null;
        try {
            // attempt to open the file which we have been told about
            FileInput = new BufferedReader(new FileReader(dataFile));
        } catch (FileNotFoundException ex) {
            // if the file does not exist a FileNotFoundException will occur
            Logger.getLogger(ScannerInt.class.getName()).log(Level.SEVERE, null, ex);
        }

        // then try searching the file
        try {
            // this while loop runs forever until it is broken below
            while (true) {
                String search = FileInput.readLine(); // we read a line and store it

                if (search == null) { // if the line is "null" that means the file has ended and their are no more lines so break
                    break;
                }

                // then we check if this line has the text

                // NOTE: i do not know what exactly you want to do here but currently this checks if the entire line
                // is exactly equal to the string. This means though that if their are other words on the line it will not count

                // Alternatively you can use search.contains(WordToSearch)
                // that will check if the "WordToSearch" is anywhere in the line. Unfortunately that will not record if there is more than one

                // (There is one more option but it is more complex but i will only mention it if you find the other two do not work)
                if (search.equals(WordToSearch)) {
                    count++;
                }
            }
        } catch (IOException ex) {
            // if the line it tries to read does not exist a IOException will occur
            Logger.getLogger(ScannerInt.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            FileInput.close(); // close the file reader
        } catch (IOException ex) {
            // if the FileInput reader has broken and therefore can not close a IOException will occur
            Logger.getLogger(ScannerInt.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }