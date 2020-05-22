import java.util.Scanner;

public class LetterCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Type a word.");
        String word = scan.nextLine();
        System.out.println("Type a single letter.");
        String letter = scan.nextLine();
        char let = letter.charAt(0);

        int count = 0;
        for (char char1: word.toCharArray()) {
            if (char1 == let) {
                count++;
            }

        }
        System.out.println(count + " " + "occurrences.");
    }
}