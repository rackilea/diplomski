import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Example {

    public static void main(String[] args) {
        try {
            byte[] name = Base64.getEncoder().encode("hello World".getBytes());
            byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
            System.out.println(new String(decodedString));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }