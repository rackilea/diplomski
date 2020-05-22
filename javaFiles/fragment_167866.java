import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        final String regex = "(?::\\[\\[)?\\[([-+]?\\d+\\.\\d+)\\s*,\\s*([-+]?\\d+\\.\\d+)\\]\\s*,?(?:\\]\\]\\}})?";
        final String string = ":[[[7.365046,46.948655],[7.365046,46.949254],[7.367558,46.949254],[7.367558,46.948655],[7.365046,46.948655]]]}}";
        final String subst = "{\"@type\": \"point\",\"lat\":\"$1\",\"lon\":\"$2\"},";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        final String result = matcher.replaceAll(subst);

        System.out.println(result);

    }
}