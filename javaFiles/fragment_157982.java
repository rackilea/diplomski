import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

public class Main {

    public static void main(String[] args) {
        try {
            byte[] name = Base64.encodeBase64("hello World".getBytes());
            byte[] decodedString = Base64.decodeBase64(new String(name).getBytes("UTF-8"));
            System.out.println(new String(decodedString));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}