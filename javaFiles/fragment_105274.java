import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacer
{
    public static String replacePlaceHolders(String text)
    {
        Map<String, String> fields = new HashMap<>();

        fields.put("name", "jack");
        fields.put("sitename", "google");

        Pattern p = Pattern.compile("\\$\\{(.*?)\\}");
        Matcher matcher = p.matcher(text);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String key = matcher.group(1);

            if (!fields.containsKey(key)) {
                continue;
            }

            matcher.appendReplacement(result, fields.get(key));
        }

        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(
                replacePlaceHolders("hai ${name} .... Welcome to ${sitename}...."));
    }
}