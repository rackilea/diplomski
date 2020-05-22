import java.util.Scanner;
import java.util.Vector;

public class TenWords {
    public static void main(String[] args) {
        Vector<String> words = new Vector<String>();

        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter ten words");

        String a;

        for (int i = 0; i < 10; i++) {
            a = userInput.next();
            words.add(a);
            System.out.println(a);
        }

        int s = words.size();
        System.out.println(s);
    }
}