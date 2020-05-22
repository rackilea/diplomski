import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

public class Play {
    public static void main(String[] args) throws IOException {
      // Method 1 for Proxy
      System.setProperty("http.proxyHost", "147.67.217.33");
      System.setProperty("http.proxyPort", "8022");
      System.setProperty("https.proxyHost", "147.67.217.33");
      System.setProperty("https.proxyPort", "8022");

      URL url=new URL("https://en.wikipedia.org/wiki/HTTPS");   
      URLConnection uc = url.openConnection();
      Authenticator.setDefault(new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication("pecador", "9ddjk69t".toCharArray());
        }
      });

      uc.connect();

      BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) 
          System.out.println(inputLine);
      in.close();
    }
}