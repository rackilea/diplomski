public class Test {
    public static void main(String[] args) {
        trim("\"foo\"");
        trim("'foo'");
        trim("\"bar'");
        trim("'bar\"");
        trim("\"'baz'\"");
    }

    static void trim(String text) {
        String trimmed = text.replaceAll("^(['\"])(.*)\\1$", "$2");
        System.out.println(text + " => " + trimmed);
    }
}