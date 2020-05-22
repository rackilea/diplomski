import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

@Slf4j
public class JsonTest {
    @Test
    public void test() throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://jsonblob.com/api/jsonBlob/5384f843e4b0441b35d1329d");
        request.addHeader("accept", "application/json");
        HttpResponse response = client.execute(request);
        String json = IOUtils.toString(response.getEntity().getContent());

        //here's where you're actually parsing the JSON
        JSONObject object = new JSONObject(json);
        JSONObject metadata = object.getJSONObject("movies_metadata");
        JSONObject movies = metadata.getJSONObject("movies");
        JSONArray movieNames = movies.names();
        for (int i = 1; i< movieNames.length(); i++) {
            String movieKey = movieNames.getString(i);
            log.info("The current object's key is {}", movieKey);
            JSONObject movie = movies.getJSONObject(movieKey);
            log.info("The Description is {}", movie.getString("Description"));
            log.info("The Movie_Logo is {}", movie.getString("Movie_Logo"));
        }
    }
}