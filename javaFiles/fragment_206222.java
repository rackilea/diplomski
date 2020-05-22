import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Example {
    public static void main(String[] args) {
        String s = "abc 30px def";
        int var = 8;

        Pattern patt = Pattern.compile("([0-9]+)px");
        Matcher m = patt.matcher(s);
        StringBuffer sb = new StringBuffer(s.length());
        while (m.find()) {
            int px = Integer.parseInt(m.group(1));
            String next = String.valueOf(var * px) + "px";
            m.appendReplacement(sb, Matcher.quoteReplacement(next));
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}