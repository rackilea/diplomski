import java.io.IOException;
    import java.net.HttpURLConnection;
    import java.net.URL;

    import org.apache.commons.codec.binary.Base64;


    public class Stack38089384 {

        public static void main(String[] args) throws IOException {
            String urlPost = "http://localhost:2480/command/Stack38089384/sql/create%20class%20Test%20extends%20v";
            URL url = new URL(urlPost);
            HttpURLConnection conexionPost = (HttpURLConnection)url.openConnection();

            String userCredentials = "root:root";
            String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
            conexionPost.setRequestProperty ("Authorization", basicAuth);
            conexionPost.setRequestMethod("POST");
            conexionPost.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexionPost.setRequestProperty("Content-Language", "en-US");
            conexionPost.setUseCaches(false);
            conexionPost.setDoInput(true);
            conexionPost.setDoOutput(true);

            System.out.println(conexionPost.getResponseCode());
        }


    }