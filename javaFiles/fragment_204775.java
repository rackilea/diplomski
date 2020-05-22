import java.util.zip.GZIPOutputStream;
import org.apache.commons.codec.binary.Base64OutputStream;

public class Test {
    public static void main(String[] args) {
        String text = "a string of characters";
        try {
            Base64OutputStream b64os = new Base64OutputStream(System.out);
            GZIPOutputStream gzip = new GZIPOutputStream(b64os);
            gzip.write(text.getBytes("UTF-8"));
            gzip.close();
            b64os.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}