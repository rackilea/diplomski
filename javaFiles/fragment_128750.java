import java.io.InputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class DoWork2 {
    // assuming data in data.txt file in same path as class files
    private static final String RESRC_PATH = "data.txt";
    private char[][] array2;

    public DoWork2(String resrcPath) {
        InputStream is = getClass().getResourceAsStream(resrcPath);
        Scanner sc = new Scanner(is);
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        array2 = new char[lines.size()][];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = lines.get(i).toCharArray();
        }
        if (sc != null) {
            sc.close();
        }
    }

    public String getLines2() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        for (char[] cs : array2) {
            formatter.format("%s%n", new String(cs));
        }
        formatter.close();
        return sb.toString();
    }

    public static void main(String[] args) {
        DoWork2 doWork2 = new DoWork2(RESRC_PATH);
        System.out.println(doWork2.getLines2());
    }

}