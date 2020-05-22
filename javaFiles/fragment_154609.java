import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Split {
public static void main(String[] args) {
    String line = "COD Amount = 333.98, Coverage = $564.000";
    String[] array = line.split(",");

    for (int i = 0; i < array.length; i++) {
        Pattern p = Pattern.compile(".+= \\$?(\\d+\\.\\d+)");
        Matcher m = p.matcher(array[i]);
        if (m.find()) {
            System.out.println(m.group(1));
        }
    }
}