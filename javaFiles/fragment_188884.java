public class Test {

    public static void main(String[] args) {
        printFormattedText("-Hello-World. My 123-phone number-456 is 333-333-333");
        printFormattedText("-123 Hello-World. My 123-phone number-456 is 333-aaa-333-");
    }

    private static void printFormattedText(String input) {
        String result = input.replaceAll("^\\-|(\\D)\\-|\\-(\\D)|\\-$", "$1 $2");
        System.out.println(result);
    }

}