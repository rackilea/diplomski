import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLServlet {

    public static void main(String s[]) {
        try {
        URL urldemo = new URL("http://www.google.com/");
        URLConnection yc = urldemo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}