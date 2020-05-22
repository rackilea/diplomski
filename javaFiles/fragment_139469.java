import java.util.regex.*;

public class HelloWorld {
    public static void main(String[] args) {
        // Create a Pattern object
        Pattern pattern = Pattern.compile("PT(\\d+H)?(\\d+M)?(\\d+S)?");
        // Now create matcher object.
        Matcher matcher = pattern.matcher("PT5M30S");

        int hour = 0;
        int minute = 0;
        int second = 0;

        if (matcher.matches()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                try {
                    String group = matcher.group(i);
                    int number = new Integer(group.substring(0, group.length() - 1));
                    if (matcher.group(i).endsWith("H")) {
                        hour = number;
                    } else if (matcher.group(i).endsWith("M")) {
                        minute = number;
                    } else if (matcher.group(i).endsWith("S")) {
                        second = number;
                    }
                } catch (java.lang.NullPointerException e) {
                    if (i == 1) {
                        hour = 0;
                    } else if (i == 2) {
                        minute = 0;
                    } else if (i == 3) {
                        second = 0;
                    }
                }
            }
        }
    }
}