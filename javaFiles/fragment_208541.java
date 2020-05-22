import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class readURL  {
    public static void main(String[] args) {
        String generate_URL = "http://www.example.com";
        String inputLine;
        try {
            URL data = new URL(generate_URL);
            /**
             * Proxy code start 
             * If you are working behind firewall uncomment below lines. 
             * Set your proxy server
             */

            /* Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.0.202", 8080)); */
            /* HttpURLConnection con = (HttpURLConnection) data.openConnection(proxy); */

            /* Proxy code end */

            /* Open connection */
            /* comment below line in case of Proxy */
            HttpURLConnection con = (HttpURLConnection) data.openConnection(); 
            /* Read webpage coontent */
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            /* Read line by line */
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            /* close BufferedReader */
            in.close();
            /* close HttpURLConnection */
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}