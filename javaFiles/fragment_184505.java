public class TestClass {
    public static void main(String[] args) {
        String input = "aa: {\n" +
                "    one: \"hello\",\n" +
                "    two: \"good\",\n" +
                "    three: \"bye\",\n" +
                "    four: \"tomorrow\",\n" +
                "  },\n" +
                "  \"bb\": {\n" +
                "    \"1\": \"a quick fox\",\n" +
                "    \"2\": \"a slow bird\",\n" +
                "    \"3\": \"a smart dog\",\n" +
                "    \"4\": \"a wilf flowert\",\n";
        // the actual code you need
        Pattern pattern = Pattern.compile("(: )(\".+\")");
        Matcher match = pattern.matcher(input);
        while (match.find()) {
            // here you go, only the value without the :
            String value = match.group(2);
            System.out.println("Found one = " + value);
        }
    }
}