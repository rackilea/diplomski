@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.2.3')
@Grab(group='org.apache.httpcomponents', module='httpcore', version='4.2.3')
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.HttpResponse
import org.apache.http.HttpEntity
import org.apache.http.entity.StringEntity
import org.apache.http.util.EntityUtils


String json = "{foo: 123, bar: \"hello\"}";

DefaultHttpClient httpclient = new DefaultHttpClient();
HttpPost httpPost = new HttpPost("http://posttestserver.com/post.php");
httpPost.setEntity(new StringEntity(json));
HttpResponse response2 = httpclient.execute(httpPost);

try {
    System.out.println(response2.getStatusLine());
    HttpEntity entity2 = response2.getEntity();
    // do something useful with the response body
    // and ensure it is fully consumed
    EntityUtils.consume(entity2);
} finally {
    httpPost.releaseConnection();
}