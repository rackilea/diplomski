import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.security.KeyStore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MyClientCertTest {

    private static final String KEYSTOREPATH = "/clientkeystore.jks"; // or .p12
    private static final String KEYSTOREPASS = "keystorepass";
    private static final String KEYPASS = "keypass";

    KeyStore readStore() throws Exception {
        try (InputStream keyStoreStream = this.getClass().getResourceAsStream(KEYSTOREPATH)) {
            KeyStore keyStore = KeyStore.getInstance("JKS"); // or "PKCS12"
            keyStore.load(keyStoreStream, KEYSTOREPASS.toCharArray());
            return keyStore;
        }
    }
    @Test
    public void readKeyStore() throws Exception {
        assertNotNull(readStore());
    }
    @Test
    public void performClientRequest() throws Exception {
        SSLContext sslContext = SSLContexts.custom()
                .loadKeyMaterial(readStore(), KEYPASS.toCharArray()) // use null as second param if you don't have a separate key password
                .build();

        HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
        HttpResponse response = httpClient.execute(new HttpGet("https://slsh.iki.fi/client-certificate/protected/"));
        assertEquals(200, response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();

        System.out.println("----------------------------------------");
        System.out.println(response.getStatusLine());
        EntityUtils.consume(entity);
    }
}