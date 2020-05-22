import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


public class Main {
    private static final Pattern KEY_VALUE_PAIR = Pattern.compile("\\(\\s?+([^,\\s]+)\\s?,\\s?+([^)\\s?]+\\s?+)\\)");
    public static void main(String[] args) {
        Map<String, String> pairs = getKeyValuePairs("[(key1,value1), (key2,value2), (key3, value3)]");
        Iterator it = pairs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); 
        }
    }

    private static Map<String, String> getKeyValuePairs(String input) {
        Map<String, String> matches = new HashMap<String, String>();
        Matcher m = KEY_VALUE_PAIR.matcher(input);
        while (m.find()) {
            matches.put(m.group(1), m.group(2));
        }
        return matches;
    }
}