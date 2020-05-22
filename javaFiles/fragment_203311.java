public class SimpleRegExp {
    public static void main(String[] args) {
        String regexp = "\\b-|-\\b";
        System.out.println(Arrays.toString("a-b-c".split(regexp)));
        System.out.println(Arrays.toString("a---c".split(regexp)));
    }
}