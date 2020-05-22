import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void main(String[] args) {

        String key = "KEY";         // rs.getString("K_PARAM")
        String value = "VALUE";     // rs.getString("L_PARAM")

        Pattern pattern = Pattern.compile("(blocE)(.{15})(" + key + "#)");

        String input ="helloworldblocE111111111111111KEY#blocE111111111111111KEY";

        Matcher m = pattern.matcher(input);

        if (m.find()) {
            String text2replace = m.group(0);
            String replacement  = m.group(1) + m.group(2) + value;
            System.out.println(input.replaceFirst(text2replace, replacement));              
        }
    }
}