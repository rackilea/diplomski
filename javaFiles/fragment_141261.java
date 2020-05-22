import java.io.*;
import java.net.*;

public class UrlReading {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://google.com");
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
    String inputLine;
    while( (inputLine = reader.readLine()) != null) {
      System.out.println(reader.readLine());
    }
  }
}