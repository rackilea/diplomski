import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main { 
    public static void main(String[] args) {
        String text = "This is AA and this is AA and this is AA and this is the END blah blah";
        Matcher m = Pattern.compile("AA(?:(?!AA).)*END").matcher(text);
        while(m.find()) {
            System.out.println("match ->"+m.group()+"<-");
        }
    }
}