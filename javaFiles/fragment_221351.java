import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.io.OutputStreamWriter;

public class Curl {

  public static void main(String[] args) {

    try {

    String url = "http://127.0.0.1:15672/api/traces/%2f/trololo";

    URL obj = new URL(url);
    HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

    conn.setRequestProperty("Content-Type", "application/json");
    conn.setDoOutput(true);

    conn.setRequestMethod("PUT");

    String userpass = "user" + ":" + "pass";
    String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes("UTF-8"));
    conn.setRequestProperty ("Authorization", basicAuth);

    String data =  "{\"format\":\"json\",\"pattern\":\"#\"}";
    OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
    out.write(data);
    out.close();

    new InputStreamReader(conn.getInputStream());   

    } catch (Exception e) {
    e.printStackTrace();
    }

  }

}