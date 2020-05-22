something like:

public class TestPattern {
    public static String[] inputTest = new String[] {
            "!LOGIN user pass",
            "!LOGIN user pass    ",
            "!LOGIN user     pass",
            "!LOGIN     user pass",
            "    !LOGIN user pass",
            "   !LOGIN    user    pass   "
    };

    public static void main(String[] argv) {
        // ^ = start of line
        // \\s* = 0 or more spaces
        // \\s+ = 1 or more spaces
        // (\\w+) = group 1 containing 1 or more word-characters (a-zA-Z etc)
        // $ = end of line 
        Pattern pattern = Pattern.compile("^\\s*!LOGIN\\s+(\\w+)\\s+(\\w+)\\s*$");
        for (String input : inputTest) {
            Matcher matcher = pattern.matcher(input);
            if (!matcher.find()) {
                System.out.println("input didn't match login: " + input);
                continue;
            }

            String username = matcher.group(1);
            String password = matcher.group(2);

            System.out.println("username[ " + username + " ], password[ " + password + " ]");
        }
    }
}