import java.util.regex.*;
class StackOverflow21028089 {
    public static void main(String[] args) {
        String s = "aaa\\u2022bbb\\u2014ccc";
        StringBuffer buf = new StringBuffer();
        Matcher m = Pattern.compile("\\\\u([0-9A-Fa-f]{4})").matcher(s);
        while (m.find()) {
            try {
                // see example:
                // http://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html#appendReplacement%28java.lang.StringBuffer,%20java.lang.String%29
                int cp = Integer.parseInt(m.group(1), 16);
                char[] chars = Character.toChars(cp);
                String rep = new String(chars);
                System.err.printf("Found %d which means '%s'\n", cp, rep);
                m.appendReplacement(buf, rep);
            } catch (NumberFormatException e) {
                System.err.println("Confused: " + e);
            }
        }
        m.appendTail(buf);
        s = buf.toString();
        System.out.println(s);
    }
}