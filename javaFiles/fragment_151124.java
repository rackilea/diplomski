import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PostGET {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<String, String> headerMap = new HashMap<String, String>();
        String bodyStr = "{\"doc\":{\"status\":\"Disconnected\"}}";
        InputStream body = new ByteArrayInputStream(bodyStr.getBytes("UTF-8"));

        System.out.println("Sending POST");
        post("http://127.0.0.1:3000", headerMap, body);

        System.out.println("");

        System.out.println("Sending GET");
        get("http://127.0.0.1:3000?test=hello", headerMap);
    }

    public static void post(String targetUrl, Map<String, String> headerMap,
            InputStream body) {
        HttpURLConnection http = null;
        try {
            http = (HttpURLConnection) new URL(targetUrl).openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            for (Map.Entry<String, String> header : headerMap.entrySet()) {
                http.setRequestProperty(header.getKey(), header.getValue());
            }

            OutputStream out = http.getOutputStream();
            out.write(readInput(body));
            out.close();

            InputStream in = http.getInputStream();
            String response = new String(readInput(in), "UTF-8");

            System.out.println("Response code: " + http.getResponseCode());
            System.out.println("Response headers : " + http.getHeaderFields());
            System.out.println("response from server: " + response);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void get(String targetUrl, Map<String, String> headerMap) {
        HttpURLConnection http = null;
        try {
            http = (HttpURLConnection) new URL(targetUrl).openConnection();
            http.setRequestMethod("GET");

            for (Map.Entry<String, String> header : headerMap.entrySet()) {
                http.setRequestProperty(header.getKey(), header.getValue());
            }

            InputStream in = http.getInputStream();
            String response = new String(readInput(in), "UTF-8");

            System.out.println("Response code: " + http.getResponseCode());
            System.out.println("Response headers : " + http.getHeaderFields());
            System.out.println("response from server: " + response);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static byte[] readInput(InputStream in) {
        ByteArrayOutputStream bais = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int readLen = -1;
        try {
            while ((readLen = in.read(buffer)) != -1) {
                bais.write(buffer, 0, readLen);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bais.toByteArray();
    }
}