import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonScanner {

    private final static String JSON_REGEX = "\\{key: (.*?), value:(.*?)(\\};|\\}$)";

    /**
     * Splits the JSON string into key/value tokens.
     * 
     * @param json  the JSON string to format
     * @return  the formatted JSON string
     */
    private String findMatched(String json) {
        Pattern p = Pattern.compile(JSON_REGEX);
        Matcher m = p.matcher(json);
        StringBuilder result = new StringBuilder();

        while (m.find()) {
            result.append("\"key\"=\"" + m.group(1) + "\", ");
            result.append("\"value\"=\"" + m.group(2) + "\" ; ");
            System.out.println("m.group(1)=" + m.group(1) + " ");
            System.out.println("m.group(2)=" + m.group(2) + " ");
            System.out.println("m.group(3)=" + m.group(3) + "\n");
        }

        return result.toString();
    }

    public static void main(String... args) {
        JsonScanner jsonScanner = new JsonScanner();
        String result = jsonScanner.findMatched("{key: TVREG, value:WestAfrica Ltd | VAT No: 1009034324829/{834324}<br/>Plot No.56634773,Road};{key: REGISTRATION, value:SouthAfricaLtd | VAT No: 1009034324829/{834324}<br />Plot No. 56634773, Road}");
        System.out.println(result);
    }

}