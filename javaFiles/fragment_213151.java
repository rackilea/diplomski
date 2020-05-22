import java.io.InputStream;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.AuthorizationHeaderSigningStrategy;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

import com.intuit.ipp.data.Account;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.net.MethodType;
import com.intuit.ipp.services.DataService;

public class POCWithoutDevkitTest {

    private DataService service;
    private OAuthConsumer oAuthConsumer;
    private static String realmID = null;

    public POCWithoutDevkitTest() {
        realmID = "122294642099";
        String consumerKey = "AAAAA";
        String consumerSecret = "BBBBB";
        String accessToken = "CCCCC";
        String accessTokenSecret = "DDDDD";

        setupContext(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    }

    public void setupContext(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
            this.oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
            oAuthConsumer.setTokenWithSecret(accessToken, accessTokenSecret);
            oAuthConsumer.setSigningStrategy(new AuthorizationHeaderSigningStrategy());
    }

    public void authorize(HttpRequestBase httpRequest) throws FMSException {
        try {
            oAuthConsumer.sign(httpRequest);
        } catch (OAuthMessageSignerException e) {
            throw new FMSException(e);
        } catch (OAuthExpectationFailedException e) {
            throw new FMSException(e);
        } catch (OAuthCommunicationException e) {
            throw new FMSException(e);
        }
    }

    public void executeGetRequest(String customURIString){
        DefaultHttpClient client = new DefaultHttpClient();
        client.getParams().setParameter("http.protocol.content-charset", "UTF-8");

        HttpRequestBase httpRequest = null;
        URI uri = null;

        try {
            uri = new URI(customURIString);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String methodtype = "GET";

        if (methodtype.equals(MethodType.GET.toString())) {
            httpRequest = new HttpGet(uri);
        }

        httpRequest.addHeader("content-type", "application/xml");
        httpRequest.addHeader("Accept","application/xml");

        try {
            authorize(httpRequest);
        } catch (FMSException e) {
            e.printStackTrace();
        }


        HttpResponse httpResponse = null;
        try {
            HttpHost target = new HttpHost(uri.getHost(), -1, uri.getScheme());
            httpResponse = client.execute(target, httpRequest);
            System.out.println("Connection status : " + httpResponse.getStatusLine());

            InputStream inputStraem = httpResponse.getEntity().getContent();

            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStraem, writer, "UTF-8");
            String output = writer.toString();

            System.out.println(output);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        POCWithoutDevkitTest withoutDevkitClient = new POCWithoutDevkitTest();
        withoutDevkitClient.executeGetRequest("https://appcenter.intuit.com/api/v1/connection/reconnect");
    }

}