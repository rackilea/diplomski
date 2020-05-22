public class SimpleTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^!(\\w+)(?:\\s+(\\S+))?");
        Matcher matcher;
        String[] testStrings = { "!command john", "!command john something", "!commandWithoutArguments",
                "!commandNoArgsButSpaces   ", "Not A command." };

        for (String testString : testStrings) {
            System.out.print("String <<" + testString + ">> ");
            matcher = pattern.matcher(testString);
            if (matcher.find()) {
                String command = matcher.group(1);
                String user = matcher.group(2);
                if (user == null) {
                    user = "default";
                }
                System.out.println("is a command: " + command + " user: " + user + ".");
            } else {
                System.out.println("is not a command.");
            }
        }
    }
}