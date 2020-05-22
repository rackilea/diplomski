enter code here
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlChecker {
public static void main(String[] args) {
System.out.println(URLExists("http://slowwly.robertomurray.co.uk/delay/
3000/url/http://www.google.co.uk"));
}

public static boolean URLExists(String targetUrl) {
    HttpURLConnection urlConnection;
    try {
        urlConnection = (HttpURLConnection) new 
        URL(targetUrl).openConnection();
        urlConnection.setRequestMethod("HEAD");
        // Set timeouts 2000 in milliseconds and throw exception
        urlConnection.setConnectTimeout(2000);
        urlConnection.setReadTimeout(2000);
       /* Set timeouts 4000 in milliseconds and it should work as the url 
        should return back in 3 seconds.
        httpUrlConn.setConnectTimeout(4000);
        httpUrlConn.setReadTimeout(4000);
        */
        System.out.println("Response Code =>"+ 
        urlConnection.getResponseCode());
        System.out.println("Response Msg =>"+ 
        urlConnection.getResponseMessage());
        return (urlConnection.getResponseCode() == 
        HttpURLConnection.HTTP_OK);
    } catch (Exception e) {
        System.out.println("Exception => " + e.getMessage());
        return false;
    }
}
}