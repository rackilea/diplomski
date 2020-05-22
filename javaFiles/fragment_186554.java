import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class GooglePlacesRequest {

    public static void main(String[] args) throws Exception {

        // Web API related
        String apiKey = "YOUR_API_KEY_HERE";
        // search params
        String location = "51.527277,-0.128625";// lat,lon
        String types = "food";
        String name = "pret";

        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("location", location));
        parameters.add(new BasicNameValuePair("radius", "500"));
        parameters.add(new BasicNameValuePair("types", types));
        parameters.add(new BasicNameValuePair("name", name));
        parameters.add(new BasicNameValuePair("sensor", "false"));
        parameters.add(new BasicNameValuePair("key", apiKey));

        URL url = new URL(
                "https://maps.googleapis.com/maps/api/place/search/json");
        URI finalURI = URIUtils.createURI(
                url.getProtocol(), 
                url.getHost(),
                url.getPort(), 
                url.getPath(),
                URLEncodedUtils.format(parameters, "UTF-8"), 
                null);

        HttpGet get = new HttpGet(finalURI);
        System.out.println("using getRequestLine(): " + get.getRequestLine());
        System.out.println("using getURI(): " + get.getURI().toString());

        DefaultHttpClient httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager());
        try {
            HttpResponse response = httpClient.execute(get);
            System.out.println("response: "
                    + response.getStatusLine().toString());
            System.out.println( "Response content is:" );
            System.out.println( EntityUtils.toString( response.getEntity() ) );
        } catch (Exception e) {
            System.err.println("HttpClient: An error occurred- ");
            e.printStackTrace();
        }

    }

}