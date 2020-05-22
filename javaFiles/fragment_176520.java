import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Please enter a multi-word sentence: ");
        String input = myScanner.next();
        System.out.println("Output: " + input);

        myScanner.close();
    }
}