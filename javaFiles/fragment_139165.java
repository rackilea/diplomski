public class Test {
    public static void main(String[] args) {
        replaceLastFour("hi");
        //"Error: The provided string is not greater than four characters long."
        replaceLastFour("Welcome to StackOverflow!");
        //"Welcome to StackOverf****"
    }

    public static String replaceLastFour(String s) {
        int length = s.length();
        if (length < 4) return "Error: The provided string is not greater than four characters long.";
        return s.substring(0, length - 4) + "****";
    }
}