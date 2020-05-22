import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Split {
public static void main(String[] args) {
    String line = "COD Amount = 333.98";
    Pattern p = Pattern.compile(".+= (\\d+\\.\\d+)");
    Matcher m = p.matcher(line);
    if (m.find()) {
        System.out.println(m.group(1));
    }
}
}