import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FindMax {
    public static void findMax(String file) throws IOException {
        Scanner fileScanner = new Scanner(new File(file));
        int max = fileScanner.nextInt();
        while (fileScanner.hasNextInt()) {
            int num = fileScanner.nextInt();
            if (num > max) {
                max=num;
            }
        }
        System.out.println(max);
        fileScanner.close();
    }

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        String file;

        System.out.print("Enter file: ");
        file = keyboard.nextLine();

        findMax(file);
        keyboard.close();
    } 
}