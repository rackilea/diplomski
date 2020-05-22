import java.net.URLEncoder;
import java.net.URLDecoder;

// ...

    public static void main (String[] args) throws java.lang.Exception
    {
            String str = "123+>jo";
            String str2 = "http://1.com/23+>jo";
            System.out.println(URLDecoder.decode(URLEncoder.encode(str)));
            System.out.println(URLDecoder.decode(URLEncoder.encode(str2)));
    }