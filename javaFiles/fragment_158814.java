import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    final static String path = Test.class.getResource("sample.txt").getPath();

    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File(path)).useDelimiter("\\.");
        List<String> phrases = new ArrayList<String>();
        while (file.hasNext()) {
            phrases.add(file.next().trim().replace("\r\n", " ")); // remove new lines
        }
        file.close();

        for (String phrase : phrases) {
            System.out.println(phrase);
        }
    }
}