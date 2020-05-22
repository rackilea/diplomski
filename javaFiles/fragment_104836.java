import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coords {

    public static void main(String[] args) {
        String input = "(123,456)";
        final Pattern pattern = Pattern.compile("^\\((\\d+?),(\\d+?)\\)$");
        final Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            System.out.println("X: " + x);
            System.out.println("Y: " + y);
        }
    }
}