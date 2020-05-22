import java.util.Scanner;

public class ReverseWord {

    public String reverse(String m) {
        String reverse = "";
        int Length = m.length();
        for (int i = Length - 1; i >= 0; i = i - 1) {
            reverse = reverse + m.charAt(i);
        }
        return reverse;
    }

    public static void main(String args[]) {
        Scanner keyIn = new Scanner(System.in);
        String store = keyIn.nextLine();
        ReverseWord rw = new ReverseWord();
        String reversedWord = rw.reverse(store);
        System.out.println(reversedWord);

    }
}