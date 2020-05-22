import java.nio.*;
import java.nio.charset.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String ascii = createString('A', 2500);
        String u00e9 = createString('\u00e9', 2500); // e-acute
        String euro = createString('\u20ac', 2500); // Euro sign
        // 4 UTF-16 code units, 3 Unicode code points
        String surrogatePair = "X\ud800\udc00Y"; 

        System.out.println(getEncodedLength(ascii, StandardCharsets.UTF_8));
        System.out.println(getEncodedLength(ascii, StandardCharsets.UTF_16BE));

        System.out.println(getEncodedLength(u00e9, StandardCharsets.UTF_8));
        System.out.println(getEncodedLength(u00e9, StandardCharsets.UTF_16BE));

        System.out.println(getEncodedLength(euro, StandardCharsets.UTF_8));
        System.out.println(getEncodedLength(euro, StandardCharsets.UTF_16BE));

        System.out.println(getEncodedLength(surrogatePair, StandardCharsets.UTF_8));
        System.out.println(getEncodedLength(surrogatePair, StandardCharsets.UTF_16BE));
    }


    private static String createString(char c, int length) {
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        return new String(chars);
    }

    public static int getEncodedLength(String text, Charset charset) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);        
        CharBuffer charBuffer = CharBuffer.wrap(text);
        CharsetEncoder encoder = charset.newEncoder();

        int length = 0;
        while (encoder.encode(charBuffer, byteBuffer, false) == CoderResult.OVERFLOW) {
            length += byteBuffer.position();
            byteBuffer.clear();
        }

        encoder.encode(charBuffer, byteBuffer, true);
        length += byteBuffer.position();
        return length;
    }
}