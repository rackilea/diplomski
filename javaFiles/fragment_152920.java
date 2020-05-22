import java.io.UnsupportedEncodingException;
import static java.net.URLEncoder.encode;

public class MainApp {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "http://www.teanglann.ie/en/gram/"+ encode("fág", "UTF-8");
        System.out.println(url);
    }
}