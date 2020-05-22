import java.util.Scanner;
import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("data.txt"));
        while (input.hasNext()) {
            input.nextInt(); // dummy line number
            int year = input.nextInt();
            int temp = input.nextInt();
            System.out.println("(" + year + ", " + temp + ")");
        }
    }
}