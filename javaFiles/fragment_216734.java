import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;

public class Test {

  public static void run() throws Throwable {

    HttpURLConnection client = null;
    OutputStreamWriter wr = null;
    BufferedReader rd = null;
    StringBuilder sb = null;
    String line = null;

    try {

      URL url = new URL("http://www.google.com");
      client = (HttpURLConnection) url.openConnection();
      client.setRequestMethod("GET");
      client.setDoOutput(true);
      client.setReadTimeout(10000);

      client.connect();
      System.out.println(" *** headers ***");
      for (Entry<String, List<String>> headernew : client.getHeaderFields().entrySet()) {
        System.out.println(headernew.getKey() + "=" + headernew.getValue());
      }

      System.out.println(" \n\n*** Body ***");
      rd = new BufferedReader(new InputStreamReader(client.getInputStream()));
      sb = new StringBuilder();

      while ((line = rd.readLine()) != null) {
        sb.append(line + '\n');
      }

      System.out.println("body=" + sb.toString());

    } finally {
      client.disconnect();
      rd = null;
      sb = null;
      wr = null;
    }
  }

  public static void main(String[] args) throws Throwable {
    run();
  }

}