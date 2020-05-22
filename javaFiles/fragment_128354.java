import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONTest {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://app.myallies.com/api/quote/goog");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:33.0) Gecko/20100101 Firefox/33.0");
        connection.setDoInput(true);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();

        String line = null;
         while ((line = reader.readLine()) != null) {
             sb.append(line + "\n");
         }

         System.out.println(sb.toString());

    }

}