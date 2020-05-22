import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Testapp {

public static void main(String[] args) {
String text = "USA v. Russia \n Some other text \n India vs. Aus";
String regex="\\w+\\s((v.)|(vs.))\\s\\w+";
Pattern p = Pattern.compile(regex);
Matcher matcher = p.matcher(text);

while (matcher.find()) {
    System.out.println(matcher.group()+ ":" +"start =" + matcher.start() + " end = " + matcher.end());
}
}
}