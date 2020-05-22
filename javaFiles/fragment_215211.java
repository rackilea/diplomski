/**
 * File:        MainTest.java
 */
package mod8;
//import mod8.CaptureURI.*;
import java.io.*;

/**
 * @author Jason D. Miller, Miller Intelligence LLC
 *
 */
public class MainTest {

    /**
     * Write a program that will display lines of a text you specify. 
     * It should take two arguments: a file or a URL and the number of lines to display. 
     * 
     * If the number of lines given is positive, it should display the first n lines of the text. 
     * If it is 0, it should display all the lines of the text. 
     * If it is a negative number, it should display the last n lines of the text. 
     * 
     * Your program should handle errors appropriately.
     */
    public MainTest() {}

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //Greet and instruct user
        System.out.println("********************************************");
        System.out.println("* Welcome to Capture URI (aka Module 8)!   *");
        System.out.println("*                                          *");
        System.out.println("*    Please enter a local file location    *");
        System.out.println("*      or web URL, then press ENTER        *");
        System.out.println("*    Next, please input the # of lines to  *");
        System.out.println("*      capture, then press ENTER           *");
        System.out.println("********************************************");

        //Get params
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in), 1);
        System.out.println("File or web URI:");
        String uri = stdin.readLine();
        System.out.println("Number of lines as an integer (0 = all, negative implies tail):");
        Integer lines = stdin.read();

        //Pass to backend
        String text = "";
        text = CaptureURI.CURI(uri, lines);

        //Print results
        System.out.println(text);
    }

}