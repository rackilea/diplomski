import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

    private HttpClient client;
    private HttpPost requestPost;

    client = HttpClientBuilder.create().build();


    requestPost = new HttpPost(url+params);
    HttpResponse response = client.execute(requestPost);
    HttpEntity entiry = response.getEntity();
    responseString = EntityUtils.toString(entiry, "UTF-8");