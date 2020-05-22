import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

    private static String removeItalic(CharSequence sequence) {
        Pattern patt = Pattern.compile("_\\*(.+?)\\*_");
        Matcher m = patt.matcher(sequence);
        StringBuffer sb = new StringBuffer(sequence.length());
        while (m.find()) {
            String text = m.group(1);
            // ... possibly process 'text' ...
            m.appendReplacement(sb, Matcher.quoteReplacement(text));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private static String removeBold(CharSequence sequence) {
        Pattern patt = Pattern.compile("\\*(.+?)\\*");
        Matcher m = patt.matcher(sequence);
        StringBuffer sb = new StringBuffer(sequence.length());
        while (m.find()) {
            String text = m.group(1);
            // ... possibly process 'text' ...
            m.appendReplacement(sb, Matcher.quoteReplacement(text));
        }
        m.appendTail(sb);
        return sb.toString();
    }


    private static String removeUrl(CharSequence sequence) {
        Pattern patt = Pattern.compile("\\[(.+?)\\|\\]");
        Matcher m = patt.matcher(sequence);
        StringBuffer sb = new StringBuffer(sequence.length());
        while (m.find()) {
            String text = m.group(1);
            // ... possibly process 'text' ...
            m.appendReplacement(sb, Matcher.quoteReplacement(text));
        }
        m.appendTail(sb);
        return sb.toString();
    }


    public static String cleanWikiFormat(CharSequence sequence) {
        return Test.removeUrl(Test.removeBold(Test.removeItalic(sequence)));
    }

    public static void main(String[] args) {
        String text = "[hello|] this is just a *[test|]* to clean wiki *type* and _*formatting*_";
        System.out.println("Original");
        System.out.println(text);
        text = Test.cleanWikiFormat(text);
        System.out.println("CHANGED");
        System.out.println(text);
    }
}