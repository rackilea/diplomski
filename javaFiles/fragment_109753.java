import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpExample {
    public static void main(String[] args) {
        String urlStr  = "http://localhost:8080/suffix/rest/of/link";
        Pattern pattern = Pattern.compile("^((.*:)//([a-z0-9\\-.]+)(|:[0-9]+)/([a-z]+))/(.*)$");

        Matcher matcher = pattern.matcher(urlStr);
        if(matcher.find())
        {
            //there is a main part of url with suffix:
            String mainPartOfUrlWithSuffix = matcher.group(1);
            System.out.println(mainPartOfUrlWithSuffix);
        }
    }
}