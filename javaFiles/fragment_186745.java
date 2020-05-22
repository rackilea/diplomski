import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner fileScanner = new Scanner("1 2 23 4\n3");
        while (fileScanner.hasNextInt()) {
            System.out.println(fileScanner.nextInt());
        }
    }

}