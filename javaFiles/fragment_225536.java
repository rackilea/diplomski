import java.io.InputStream;
import java.util.Scanner;

public class ScanFile {
    public static void main(String[] args) {
        try {
            InputStream is = ScanFile.class.getClassLoader().getResourceAsStream("resources/foo.txt");
            Scanner scan = new Scanner(is);
            scan.useDelimiter("\\.[\r\n]+"); // Tokenize at dots (.) followed by CR/LF.

            int i = 1;
            while (scan.hasNext()) {
                String line = scan.next().trim();

                System.out.printf("Line #%d%n-------%n%n%s%n%n", i++, line);
            }

            scan.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}