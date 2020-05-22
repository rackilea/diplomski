import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;

public class HttpClient {

    public static void main(String args[]) throws IOException {
        String stringUrl = "https://qualysapi.qualys.eu/api/2.0/fo/report/?action=list";
        URL url = new URL(stringUrl);
        URLConnection uc = url.openConnection();

        uc.setRequestProperty("X-Requested-With", "Curl");

        String userpass = "username" + ":" + "password";
        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
        uc.setRequestProperty("Authorization", basicAuth);

        InputStreamReader inputStreamReader = new InputStreamReader(uc.getInputStream());
        // read this input

    }
}