public class StringComparison {
    public static void main(String[] args) {
        String s = "a|b";
        String t = "a|b\0";
        System.out.println(":" + s + ":" + t + ":");
        System.out.println(s.equals(t));
    }
}