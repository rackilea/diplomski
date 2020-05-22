import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;        


HttpClient client = HttpClientBuilder.create().build();
HttpGet requestGet = new HttpGet(url + params);
HttpResponse response = client.execute(requestGet);
HttpEntity entity = response.getEntity();
responseString = EntityUtils.toString(entity, "UTF-8");