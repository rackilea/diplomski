import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class RateCardRest {

    public static String getAccessToken(String tenantId, String clientId, String clientSecret)
            throws MalformedURLException, IOException {
        String endpoint = String.format("https://login.microsoftonline.com/%s/oauth2/token", tenantId);
        String postBody = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s&resource=%s",
                clientId, clientSecret, "https://management.azure.com/");
        HttpURLConnection conn = (HttpURLConnection) new URL(endpoint).openConnection();
        conn.setRequestMethod("POST");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);
        conn.getOutputStream().write(postBody.getBytes());
        conn.connect();
//      If you want to see the response content, please use the commented code below.
//      BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//      StringBuilder builder = new StringBuilder();
//      String line = null;
//      while ((line = reader.readLine()) != null) {
//          builder.append(line);
//      }
//      reader.close();
//      System.out.println(builder.toString());
//      The output for access token is {"token_type":"Bearer","expires_in":"3600","ext_expires_in":"3600","expires_on":"1550660092","not_before":"1550656192","resource":"https://management.azure.com/","access_token":"eyJ0eXAiOiJKV1QiL...."}
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(conn.getInputStream());
        String accessToken = null;
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String name = parser.getCurrentName();
            if ("access_token".equals(name)) {
                parser.nextToken();
                accessToken = parser.getText();
            }
        }
        return accessToken;
    }

    public static String getRateCard(String subscriptionId, String apiVersion, String offerId, String currency,
            String locale, String region, String accessToken) throws MalformedURLException, IOException {
        String endpoint = String.format(
                "https://management.azure.com/subscriptions/%s/providers/Microsoft.Commerce/RateCard?api-version=%s&$filter=OfferDurableId eq '%s' and Currency eq '%s' and Locale eq '%s' and RegionInfo eq '%s'",
                subscriptionId, apiVersion, offerId, currency, locale, region).replaceAll(" ", "%20");
        HttpURLConnection conn = (HttpURLConnection) new URL(endpoint).openConnection();
        conn.setRequestMethod("GET");
        conn.addRequestProperty("Authorization", "Bearer " + accessToken);
        conn.addRequestProperty("Content-Type", "application/json");
        conn.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        return builder.toString();
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        String tenantId = "<your tenant id like xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxxx";
        String clientId = "<your client id registed in AAD like xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxxx";
        String clientSecret = "<your client secret key generated in AAD>";
        String accessToken = getAccessToken(tenantId, clientId, clientSecret);
        System.out.println(accessToken);
        String subscriptionId = "<your subscription id like xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxxx";
        String apiVersion = "2015-06-01-preview";
        String offerId = "<your offer id like XX-AZR-XXXXX";
        String currency = "USD";
        String locale = "en-US";
        String region = "US";
        String rateCardResp = getRateCard(subscriptionId, apiVersion, offerId, currency, locale, region, accessToken);
        System.out.println(rateCardResp);
    }

}