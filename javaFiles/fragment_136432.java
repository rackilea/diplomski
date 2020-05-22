import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Test1 {

    public static void main(String[] args) throws IOException {
        String user = "ENTER YOUR USERNAME";
        String password = "ENTER YOUR PASSWORD";
        String auth = user + ":" + password;
        URL url = new URL("https://scihub.copernicus.eu/dhus/odata/v1/");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString((auth).getBytes(StandardCharsets.UTF_8)); // Java
        connection.setRequestProperty("Authorization", basicAuth);
        connection.connect();
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getContent());

    }

}