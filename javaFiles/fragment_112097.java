import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    private static final Pattern ptninhref;
    static{
        ptninhref = Pattern.compile("(?<=[>])(\\\\?.)*?(?=[<])");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String href= "<a href=\"paypal.com/signin/\">https://www.paypa1.com/signin/</a>";
        List<String> results = captureValuesinhref(href);
        for(String result:results){
            System.out.print(result);
        }
    }

    public static List<String> captureValuesinhref(String largeText){
        Matcher mtchinhref = ptninhref.matcher(largeText);
        List<String> inHREF = new ArrayList<String>();
        while(mtchinhref.find()){
           inHREF.add(mtchinhref.group());
        }
        return inHREF;
    }
}