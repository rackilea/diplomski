import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class HTTPTestClient {

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8090/druid/indexer/v1/task";
        String content = new String(Files.readAllBytes(Paths.get("quickstart/ingest_statistic_hourly_generate.json")));

        HttpClient client = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost(url);

        post.addHeader("Accept", "application/json");
        post.addHeader("charset", "UTF-8");
        post.addHeader("Content-Type", "application/json");
        post.setEntity(new StringEntity(content));

        HttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine());
        System.out.println("Response Code : " + response);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result);

    }
}