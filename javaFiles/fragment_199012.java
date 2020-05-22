import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class TestClass {

    public static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";

    public static final String POST_DATA = "{\"userId\": 100,\"id\": 100,\"title\": \"main title\",\"body\": \"main body\"}";

    public static void main(String[] args) throws Exception {
        String[] details = {};
        System.out.println(Arrays.toString(details));

        URL line_api_url = new URL(POST_URL);
        String payload = POST_DATA;

        HttpURLConnection linec = (HttpURLConnection) line_api_url
                .openConnection();
        linec.setDoInput(true);
        linec.setDoOutput(true);
        linec.setRequestMethod("POST");
        linec.setRequestProperty("Content-Type", "application/json");
        linec.setRequestProperty("Authorization", "Bearer "
                + "1djCb/mXV+KtryMxr6i1bXw");

        OutputStreamWriter writer = new OutputStreamWriter(
                linec.getOutputStream(), "UTF-8");
        writer.write(payload);

        BufferedReader in = new BufferedReader(new InputStreamReader(
                linec.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}