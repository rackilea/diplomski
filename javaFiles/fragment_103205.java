public class Example {
    public static void main(String[] args) {
        System.out.println(getHex(255, 255, 255)); // #fff
        System.out.println(getHex(255, 240, 255)); // #fff0ff
    }

    static String getHex(int r, int g, int b) {
        return String.format("#%02x%02x%02x", r, g, b).replaceAll("^#([a-fA-F])\\1([a-fA-F])\\2([a-fA-F])\\3$", "#$1$2$3");
    }
}