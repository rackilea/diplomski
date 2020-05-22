import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Simple demonstration of a reader
 *
 * @author jasonmp85
 *
 */
public class ReaderClass {

    /**
     * Reads two integers from standard in and prints their sum
     *
     * @param args
     *            unused
     */
    public static void main(String[] args) {
        // System.in is standard in. It's an InputStream, which means
        // the methods on it all deal with reading bytes. We want
        // to read characters, so we'll wrap it in an
        // InputStreamReader, which can read characters into a buffer
        InputStreamReader isReader = new InputStreamReader(System.in);

        // but even that's not good enough. BufferedReader will
        // buffer the input so we can read line-by-line, freeing
        // us from manually getting each character and having
        // to deal with things like backspace, etc.
        // It wraps our InputStreamReader
        BufferedReader reader = new BufferedReader(isReader);
        try {
            System.out.println("Please enter a number:");
            int firstInt = readInt(reader);

            System.out.println("Please enter a second number:");
            int secondInt = readInt(reader);

            // printf uses a format string to print values
            System.out.printf("%d + %d = %d",
                              firstInt, secondInt, firstInt + secondInt);
        } catch (IOException ioe) {
            // IOException is thrown if a reader error occurs
            System.err.println("An error occurred reading from the reader, "
                               + ioe);

            // exit with a non-zero status to signal failure
            System.exit(-1);
        } finally {
            try {
                // the finally block gives us a place to ensure that
                // we clean up all our resources, namely our reader
                reader.close();
            } catch (IOException ioe) {
                // but even that might throw an error
                System.err.println("An error occurred closing the reader, "
                                   + ioe);
                System.exit(-1);
            }
        }

    }

    private static int readInt(BufferedReader reader) throws IOException {
        while (true) {
            try {
                // Integer.parseInt turns a string into an int
                return Integer.parseInt(reader.readLine());
            } catch (NumberFormatException nfe) {
                // but it throws an exception if the String doesn't look
                // like any integer it recognizes
                System.out.println("That's not a number! Try again.");
            }
        }
    }
}