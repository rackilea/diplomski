import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("Test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("#");
            for (int i = 0; i < words.length; i++) {
                if (i == words.length - 1) {
                    System.out.print(formatString(words[i], 20));
                } else {
                    System.out.print(formatString(words[i], 20) + "|");
                }
            }
            System.out.println();
        }

    }

    static String formatString(String word, int length) {
        return new String(new char[5]).replace('\0', ' ') + word + new String(new char[length - word.length()]).replace('\0', ' ');
    }
}