import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String wordInput = input.nextLine();

        System.out.print("Enter a number: ");
        int numberInput = input.nextInt();

        StringBuilder updatedStr = new StringBuilder();
        for (char c : wordInput.toCharArray()) {
            updatedStr.append((char) (c + numberInput));
        }
        System.out.println("Updated string: " + updatedStr);
    }
}