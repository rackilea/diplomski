import java.util.Scanner;

public class SampleRead {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int readValue = 0;
        while((readValue = scanner.nextInt()) != 5) {
            System.out.println("Send me something other than " + readValue);
        }
        System.out.println("Good job. Bye");
    }
}