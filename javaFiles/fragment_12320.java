import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseWithRegexp {
    static String str = "[amt is E234.98.valid 23/12/2013.Sample text  E134.95.valid 23/12/2015]";
    public static void testIt() {
        Pattern p = Pattern.compile("E([0-9.]+)\\.valid");
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println("found: "+m.group(1));
        }
    }
}