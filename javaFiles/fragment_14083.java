import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicNameValuePair;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HttpPostDemo {

    public static void main(String[] args) throws Exception {

        String url = ... // TODO provide this.

        HttpPost httpPost = new HttpPost(url);
        // Add the header Content-Type: application/x-www-form-urlencoded; charset=UTF-8.
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.withCharset(StandardCharsets.UTF_8).getMimeType());

        // Construct the POST data.
        List<NameValuePair> postData = new ArrayList<>();
        postData.add(new BasicNameValuePair("example_key", "example_value"));
        // add further keys and values, the one above is only an example.

        // Set the POST data in the HTTP request.
        httpPost.setEntity(new UrlEncodedFormEntity(postData, StandardCharsets.UTF_8));

        // TODO make the request...
    }
}