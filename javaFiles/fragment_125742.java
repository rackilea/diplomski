import java.nio.charset.StandardCharsets;

public class Dashes {

    public static void main(String[] args) {
        // see: https://en.wikipedia.org/wiki/Dash
        byte[] enDash = {-30, -128, -109};
        byte[] minusSign = {45};
        byte[] emDash = {-30, -128, -108};

        byte[][] charBytes = new byte[3][];
        charBytes[0] = enDash;
        charBytes[1] = minusSign;
        charBytes[2] = emDash;

        for (byte[] bytes : charBytes) {
            String s = new String(bytes, StandardCharsets.UTF_8);
            char c = s.charAt(0);
            System.out.printf("%d  %s  %s%n", s.length(), c, Character.getName(c));
        }
    }
}