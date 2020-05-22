import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class App1 {

    public static void main(String[] args) throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://_google_url_");
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:8.0) Gecko/20100101 Firefox/8.0");
        HttpResponse execute = httpclient.execute(httpget);
        File file = new File("google.html");
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file);
            execute.getEntity().writeTo(fout);
        } finally {
            if (fout != null) {
                fout.close();
            }
        }
    }
}