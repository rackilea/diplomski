import java.io.UnsupportedEncodingException;


public class Encoding
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        String s = "Hello world";
        byte[] b = s.getBytes("US-ASCII");
    }
}