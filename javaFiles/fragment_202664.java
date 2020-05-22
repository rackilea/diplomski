public class Test {
    public static void main(String[] args) {
        String emoji = "\ud83d\ude04";
        System.out.println(emoji.length()); // 2
        System.out.println(emoji.codePointCount(0, emoji.length())); // 1
    }
}