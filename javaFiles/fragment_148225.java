import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser
{
    public static void main(final String[] args)
    {
        final String s1 = "(3:2,1)";
        final String s2 = "(3:null,1)";
        final Pattern p = Pattern.compile("\\((\\d+):(\\d+|null),(\\d+)\\)");
        final Matcher m1 = p.matcher(s1);
        m1.matches();
        System.out.format("Object1=%s; Object2=%s; Object3=%s", m1.group(1), m1.group(2), m1.group(3));
        System.out.println();
        final Matcher m2 = p.matcher(s2);
        m2.matches();
        System.out.format("Object1=%s; Object2=%s; Object3=%s", m2.group(1), m2.group(2), m2.group(3));
    }
}