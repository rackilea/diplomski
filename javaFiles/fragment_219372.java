import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rgx {

    private String str1 = "", str2 = "", date = "";

    public static void main(String[] args) {
        String fileName = "Genr_Report_123_for_20151105.xls";

        Rgx rgx = new Rgx();
        rgx.extractValues(fileName);
        System.out.println(rgx.str1 + " " + rgx.str2 + " " + rgx.date);
    }

    private void extractValues(String fileName) {
        Pattern pat = Pattern.compile("([^_]+)_Report_([^_]+)_for_([\\d]+)\\.xls");
        Matcher m = pat.matcher(fileName);

        if (m.find()) {
            str1 = m.group(1);
            str2 = m.group(2);
            date = m.group(3);
        }
    }
}