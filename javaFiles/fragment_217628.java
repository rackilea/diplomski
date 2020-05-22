public class __QuickTester {

    public static void main (String [] args) {

        String test = "abc|abc (abc\\|abc)|def|banana\\|apple|orange";

        // \\\\ becomes \\ <-- String
        // \\ becomes \ <-- In Regex
        String[] result = test.split("(?<!\\\\)\\|");

        for(String part : result) {
            System.out.println(part);
        }
    }
}