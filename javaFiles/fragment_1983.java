import java.util.regex.*;
class Test {
    public static void main(String[] args) {
        char[] special = Character.toChars(0x1F4F1);
        String text = "Hi\n\nyo keep this here\n\n" + new String(special) + "Unicode b4 keep all from here\n\nyo\ncut me:\n\nThis should be deleted";
        Pattern PATTERN = Pattern.compile("^(.+?)\\nyo(?:(?!cut me:|\\nyo).)*cut me:",
                Pattern.DOTALL);
        Matcher m = PATTERN.matcher(text);
        if (m.find()) {
            text = m.group(1);
            System.out.println(text);
        }
    }
}