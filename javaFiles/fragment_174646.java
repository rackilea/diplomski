import java.lang.System.*;
import java.util.*;

public class StringChecker {

    public static void main (String[] args) {
        String fullString = args[0];
        String subString = "xyz";

        if (fullString.length() < subString.length()) {
            System.out.println("'" + subString + "' not found in '" + fullString + "'");
            System.exit(0);
        }
        int i = 0;
        do {
            if (fullString.charAt(i) == subString.charAt(0) &&
                fullString.charAt(i + 1) == subString.charAt(1) &&
                fullString.charAt(i + 2) == subString.charAt(2)) {
                   System.out.println("'" + subString + "' is present in '" + fullString + "'");
                   System.exit(0);
            }
       } while (i++ < fullString.length() - subString.length());

        System.out.println(subString + "not found in '" + fullString + "'");
        System.exit(0);
    }
}