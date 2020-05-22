import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> board = new ArrayList<String>();
        int num = scan.nextInt();
        scan.nextLine();
        int num1 = 0;
        String num2 = "";
        String word = "";
        String word1 = "";
        for (int i = 0; i <= num; i++) {
            word = scan.nextLine();
            if (word.length() > 10) {
                num1 = word.length() - 2;
                num2 = Integer.toString(num1);
                word1 = word.charAt(0) + num2 + word.charAt(word.length() - 1);
                board.add(word1);
            } else {
                board.add(word);
            }
        }

        for (int i = 0; i <= num; i++) {
            System.out.println(board.get(i));
        }
    }
}