import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {

    private static Scanner input;

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("File name not specified.");
            System.exit(1);
        }

        try {
            File file = new File(args[0]);
            input = new Scanner(file);
        } catch (IOException ioException) {
            System.err.println("Cannot open file.");
            System.exit(1);
        }

        int total = 0;
        while (input.hasNext()) {
            total += 1;
            input.next();
        }

        System.out.printf("The total number of words without duplication is: %d", total);

        input.close();
    }

}