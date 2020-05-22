import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public Test2() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        String toTest = getIDFromYoutubeURL(
                "https://gdata.youtube.com/feeds/api/users/Test/?id=c&v=2");
        System.out.println(toTest);
    }

    public static String getIDFromYoutubeURL(String ytURL ) {
        if(ytURL.startsWith("https://gdata")) {  // This is my obviously silly hack,      
           ytURL = ytURL.replaceAll("v=\\d", ""); // I belive Regext should handle this.
        }
        String pattern = "(?i)(https://gdata\\.)?(youtu(?:\\.be|be\\.com)/(?:.*v(?:/|=)|(?:.*/)?)([\\w'-]+))";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(ytURL);

        if(matcher.find()){
            return matcher.group(3);
        }
        return null;
    }
}