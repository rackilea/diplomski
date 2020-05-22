public class Main {
    public static void main(String[] args) {
        String[] tests = {
                "<a href=\"http://xyz\">xyz</a>",
                "<a href=\"https://xyz\">xyz</a>",
                "<a href=\"xyz\">xyz</a>",
                "<a href=\"xyz\">xyzzz</a>"
        };
        String regex = "<a\\s+href=\"(?:https?://)?([^\"]+)\">\\1</a>";
        for(String test : tests) {
            System.out.println(test.matches(regex));
        }
    }
}