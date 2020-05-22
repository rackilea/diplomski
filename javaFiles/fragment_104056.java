import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchDemo {

    public static void main(String[] args) {
        String data = "1|002|3|Lubna|M|141021081331|\n"
                + "2|003|3|Rashid|1|141021081431|\n"
                + "3|002|3|Amal|M|141021081340|\n"
                + "4|002|3|Lubna|F|141021081531|";

        Pattern p = Pattern.compile("^\\d+[|]\\d+[|]\\d+[|]([^|]+)[|]([M]?)[|]\\d+[|]", Pattern.MULTILINE);
        Matcher m = p.matcher(data);
        while (m.find()) {
            System.out.println("search name: " + m.group(1) + " type: " + m.group(2));
            Pattern p2 = Pattern.compile("^\\d+[|]\\d+[|]\\d+[|](" + m.group(1) + ")[|]([F]?)[|]\\d+[|]", Pattern.MULTILINE);
            Matcher m2 = p2.matcher(data);
            if (m2.find()) {
                System.out.println("found name: " + m2.group(1) + " type: " + m2.group(2));
            } else {
                System.out.println("no match name: " + m.group(1) + " type: " + m.group(2));
            }
        }
    }
}