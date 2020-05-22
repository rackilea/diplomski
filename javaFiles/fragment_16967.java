import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.text.ParseException;

public class ConsoleMain {
    public static void main(String[] args) throws IOException, ParseException {
        StringBuilder sb1 = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        for (int i=0;i<19;i++) {
            sb1.append(sb1);
        }
        System.out.println("Size of buffer: "+sb1.length());
        byte[] src = sb1.toString().getBytes("UTF-8");
        StringBuilder res;

        long startTime = System.currentTimeMillis();
        res = testStringConvert(src);
        System.out.println("Conversion using String time (msec): "+(System.currentTimeMillis()-startTime));
        if (!res.toString().equals(sb1.toString())) {
            System.err.println("Conversion error");
        }

        startTime = System.currentTimeMillis();
        res = testCBConvert(src);
        System.out.println("Conversion using CharBuffer time (msec): "+(System.currentTimeMillis()-startTime));
        if (!res.toString().equals(sb1.toString())) {
            System.err.println("Conversion error");
        }
    }

    private static StringBuilder testStringConvert(byte[] src) throws UnsupportedEncodingException {
        String s = new String(src, "UTF-8");
        StringBuilder b = new StringBuilder(s);
        return b;
    }

    private static StringBuilder testCBConvert(byte[] src) throws CharacterCodingException {
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        ByteBuffer srcBuffer = ByteBuffer.wrap(src);
        CharBuffer resBuffer = decoder.decode(srcBuffer);
        StringBuilder b = new StringBuilder(resBuffer);
        return b;
    }
}