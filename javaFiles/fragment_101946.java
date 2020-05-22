package test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;


public class HTTPSCustomTruststore {

    public final static void main (String argv[]) throws Exception{
        request("https://www.google.com/", "test/google.jks", "pa55w0rd"); //Expected OK 
        request("https://www.aragon.es/","test/google.jks","pa55w0rd");  // Expected  FAIL
        request("https://www.aragon.es/",null,null); //using default truststore. OK 
    }

    public static void configureCustom(HttpsURLConnection connection, String truststore, String pwd)throws Exception{
        TrustManagerFactory trustManagerFactory = 
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyStore keystore = KeyStore.getInstance("JKS");
        InputStream keystoreStream = HTTPSCustomTruststore.class.getClassLoader().getResourceAsStream(truststore);
        keystore.load(keystoreStream, pwd.toCharArray());
        trustManagerFactory.init(keystore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, trustManagers,  new java.security.SecureRandom());

        SSLSocketFactory socketFact = context.getSocketFactory();
        connection.setSSLSocketFactory(socketFact);
    }


    public static void request(String urlS, String truststore, String pwd) {
        try {
            URL url = new URL(urlS);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (truststore != null) {
                configureCustom((HttpsURLConnection) conn, truststore, pwd);
            }   
            conn.connect();

            int statusCode = conn.getResponseCode();
            if (statusCode != 200) {
                System.out.println(urlS + " FAIL");
            } else {
                System.out.println(urlS + " OK");
            }
        } catch (Exception e) {
            System.out.println(urlS + " FAIL " + e.getMessage());
        }
    }
}