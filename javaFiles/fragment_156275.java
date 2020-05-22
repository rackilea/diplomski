import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample {

    public static void main(String[] args) {
        String v1 = "a, 2.0, 2.0, 3.0\r\nb, 1.0, 3.0, 6.8\r\nc, 4.0, 2.8, 5.4\r\n";
        List<String> list = new ArrayList<String>();
        for(String line: v1.split("\r\n")) {
            list.add(line);
        }
        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                Float f1 = Float.parseFloat(s1.split(",")[3].trim());
                Float f2 = Float.parseFloat(s2.split(",")[3].trim());
                return f2.compareTo(f1);
            }
        });
        StringBuilder result = new StringBuilder();
        for(String line: list) {
            System.out.println(line);
            result.append(line+"\r\n");
        }
        System.out.println(result.toString());
    }
}