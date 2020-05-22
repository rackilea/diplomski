import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTest {

/**
 * @param args
 */
public static void main(String[] args) {


        Pattern pattern = Pattern.compile("(\\*)(?:\\S.*\\S)(\\*)");

        String string ="for example *y text1 text2 u*";
        Matcher matcher = pattern.matcher(string);

        boolean found = false;
        if (matcher.find()) {
            System.out.println("group count:"+matcher.groupCount());
            System.out.println("---------------");
            for(int i=1; i<=matcher.groupCount(); i++)
            {
                System.out.println("group "+i);
                System.out.println("start index:"+matcher.start(i));
                System.out.println("end index:"+matcher.end(i));
                System.out.println("text:"+string.substring(matcher.start(i), matcher.end(i)));
                System.out.println("---------------");
            }

            found = true;
        }
        if(!found){
            System.out.println("not found.");
        }



}

}