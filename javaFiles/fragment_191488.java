import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpRequest;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.List;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HttpClientTest
{
    public static void main(String[] args) throws Exception
    {
        // initialize some variables
        String referer = "URL of referring web page goes here";
        String submitUrl = "https URL of form action goes here";
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("firstName", "John"));
        formparams.add(new BasicNameValuePair("lastName", "Doe"));

        // set up httppost
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
        HttpPost httppost = new HttpPost(submitUrl);
        httppost.setEntity(entity);

        // add referer
        httppost.addHeader("Referer", referer);

        // create httpclient
        DefaultHttpClient httpclient = new DefaultHttpClient();

        // execute the request
        HttpResponse response = httpclient.execute(httppost);

        // display the response body
        HttpEntity responseEntity = response.getEntity();
        OutputStream out = new ByteArrayOutputStream();
        responseEntity.writeTo(out);
        System.out.println(out);
    }
}