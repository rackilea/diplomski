import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homework4 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter choice: ");

        switch (input.nextInt()) {
        // If 1 is given as input...
        case 1:
            // As we press "enter" after inputting 1, the newline is read by the
            // scanner. We skip this newline by doing this.
            input.nextLine();

            System.out.println("Enter first string: ");
            String s1 = input.nextLine();

            System.out.println("Enter second string: ");
            String s2 = input.nextLine();

            System.out.println("Result: " + contains(s1, s2));
            break;
        // If 2 is given as input (just for the sake of the example)
        case 2:
            System.out.println("You chose an unimplemented choice.");
            break;
        // If something else is given as input...
        default:
            System.out.println("Nothing to do...");
            break;
        }

        // As Scanner is considered a resource, we have to close it, now that
        // we're done using it.
        input.close();
    }

    // This is the RegEx implementation
    public static int containsRegx(String s1, String s2) {
        Pattern p = Pattern.compile(s2 + "(?!.*" + s2 + ")");
        Matcher m = p.matcher(s1);

        if (m.find())
            return m.start();

        return -1;
    }

    // This is the charAt and length only
    public static int contains(String s1, String s2) {
        int i = s2.length() - 1, j = s1.length() - 1;

        if(i > j || i * j == 0)
            return -1;

        for (; i > -1; i--) {
            for (; j >= 0; j--) {
                if (s1.charAt(j) == s2.charAt(i)) {
                    if (i == 0)
                        return j;

                    if (j != 0)
                        j--;

                    break;
                } else if (i != s2.length()) {
                    i = s2.length() - 1;
                }
            }
        }

        return -1;
    }
}