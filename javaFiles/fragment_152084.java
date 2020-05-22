public class Main {
    public static void main(String[] args) {
        char nonAscii = 0x00FF;
        String asciiText = "Day";
        String nonAsciiText = "Night " + nonAscii;
        System.out.println(asciiText.matches("\\A\\p{ASCII}*\\z"));
        System.out.println(nonAsciiText.matches("\\A\\p{ASCII}*\\z"));
    }
}