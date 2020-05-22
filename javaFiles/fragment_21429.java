import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HelloWorld {
    public static void testUrl(String urlString) throws MalformedURLException {
        URLConnection conn = null;
        System.out.println("Testing URL " + urlString);
        try {
            URL url = new URL(urlString);
            conn = url.openConnection();

            // Just to make the exception happen
            conn.getInputStream();

            System.out.println("Success!");
        } catch(IOException ex) {
            System.out.println("Error!");
            System.out.println();

            // Method 2 with access to the URLConnection object
            // (Method 1 would have been having the connection as HttpURLConnection from the beginning.)
            int responseCode = 0;
            System.out.println("Trying method 2 to get status code");

            try {
                if(conn != null) {
                    // Casting to HttpURLConnection allows calling getResponseCode
                    responseCode = ((HttpURLConnection)conn).getResponseCode();
                } else {
                    System.out.println("conn variable not set");
                }
            } catch(IOException ex2) {
                System.out.println("getResponseCode threw: " + ex2);
            }

            System.out.println("Status code from calling getResponseCode: " + responseCode);
            System.out.println();

            // Method 3 without access to the URLConnection object
            responseCode = 0;
            System.out.println("Trying method 3 to get status code");

            // First we try parsing the exception message to see if it contains the response code
            Matcher exMsgStatusCodeMatcher = Pattern.compile("^Server returned HTTP response code: (\\d+)").matcher(ex.getMessage());
            if(exMsgStatusCodeMatcher.find()) {
                responseCode = Integer.parseInt(exMsgStatusCodeMatcher.group(1));
            } else if(ex.getClass().getSimpleName().equals("FileNotFoundException")) {
                // 404 is a special case because it will throw a FileNotFoundException instead of having "404" in the message
                System.out.println("Got a FileNotFoundException");
                responseCode = 404;
            } else {
                // There can be other types of exceptions not handled here
                System.out.println("Exception (" + ex.getClass().getSimpleName() + ") doesn't contain status code: " + ex);
            }

            System.out.println("Status code from parsing exception message: " + responseCode);
            System.out.println();
        }

        System.out.println("-------");
        System.out.println();
    }

    public static void main(String []args) throws MalformedURLException {
        testUrl("https://httpbin.org/status/200");
        testUrl("https://httpbin.org/status/404");
        testUrl("https://httpbin.org/status/403");
        testUrl("http://nonexistingsite1111111.com");
    }
}