import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FReader {
    public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Enter file name:");
    Scanner input = new Scanner(System.in);
    String fname = input.nextLine();
    File file = new File(fname);
    Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringTokenizer tokens = new StringTokenizer(line);
            String command = tokens.nextToken();
            String info = tokens.nextToken();
            System.out.println("command = " + command + " info = " + info);
        }
    }
}