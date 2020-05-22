import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args)
    {
        String Text = "0.4 - 1.2 Mathematics";
        Pattern p = Pattern.compile("^" + // Match the start of the string
                "(\\d+(?:\\.\\d+)?)" + // Match the first float, the fraction is optional, (?:) is a non capturing group
                "(?:\\s*-\\s*" + // Match the whitespace and the - . This part including the following float is optional
                "(\\d+(?:\\.\\d+)?))?" + // Match the second float, because of the ? at the end this part is optional
            "\\s*(.*)" + // Match the whitespace after the numbers and put the rest of the chars in the last capturing group
            "$"); // Match the end of the string

        Matcher m = p.matcher(Text);

        if (m.matches()) {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        }
    }
}