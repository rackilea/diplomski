import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathSplitTest
{
    public static void main(String[] args)
    {
        Pattern pattern = Pattern.compile("[0-9]+|[-+]");
        String string = "5+3--323";                 
        Matcher matcher = pattern.matcher(string);
        while(matcher.find())
            System.out.println("g0="+matcher.group(0));
    }
}