import java.util.Scanner;

public class TestIO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Print something:");    // printing output
        String text = scanner.nextLine();          // taking input

        System.out.println("You have printed the following text: " + text);
    }

}