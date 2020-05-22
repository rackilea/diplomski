import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class PlainJavaHTTPSTest {

    @BeforeClass
    public static void setUp() {
        System.setProperty("javax.net.ssl.keyStore", "/full/path/to/clientkeystore-samepassword.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "keystorepass");
    }

    @Test
    public void testPlainJavaHTTPS() throws Exception {
        String httpsURL = "https://slsh.iki.fi/client-certificate/protected/";
        URL myUrl = new URL(httpsURL);
        HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
        try (InputStream is = conn.getInputStream()) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }
        }
    }
}