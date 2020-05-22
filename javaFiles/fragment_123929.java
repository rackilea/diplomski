import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
public class Test1 {

static String urlstr = "http://127.0.0.1:8989";
public static void main(String argv) throws IOException{
    URL url = new URL(urlstr);
    Test1 t = new Test1();
    for (int i = 0; i < 10; i++) {
        t.sendRequest("Hello HTTP server!! I'm your client" + i, url);
    }

}

private void sendRequest(String strToSend, URL url) throws IOException{

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setDoOutput(true);

    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
    writer.write(strToSend);

    InputStream in  = connection.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    StringBuilder result = new StringBuilder();
    String line;
    while((line = reader.readLine()) != null) {
        result.append(line);
        System.out.println(result.toString());
    }
}