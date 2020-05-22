import java.nio.charset.Charset;
import java.util.Arrays;

public class CSTest {
    public static void main(String[] argv) {
        Charset cs = Charset.forName("GBK");
        byte[] bytes = new byte[256];
        for (int i=0; i<bytes.length; ++i)
            bytes[i] = (byte) i;
        System.out.println(Arrays.toString(bytes));
        String s = new String(bytes, cs);
        byte[] b2 = s.getBytes(cs);
        System.out.println(Arrays.toString(b2));
    }
}