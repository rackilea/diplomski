import java.io.UnsupportedEncodingException;

public class Test
{
    public static int getCodePoint(String s) throws UnsupportedEncodingException
    {
        byte[] a = s.getBytes("UTF-32BE");
        return ((a[1] & 0xFF) << 16) + ((a[2] & 0xFF) << 8) + (a[3] & 0xFF);
    }

    public static void main(String []args) throws UnsupportedEncodingException
    {
        System.out.println(getCodePoint("A")); // 65
        System.out.println(getCodePoint("")); // 128514
    }
}