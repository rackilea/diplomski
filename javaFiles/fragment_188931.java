import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class URLExp {

    public static void main(String[] args) {
        try {
            URL google = new URL("http://www.google.com/");
            URLConnection yc = google.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc
                    .getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);

            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}