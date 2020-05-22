import org.apache.commons.io.IOUtils;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Test1 {
    private static String key = "<your translator account key>";

    public static void main(String[] args) {
        try {
            // Get the access token
            // The key got from Azure portal, please see https://docs.microsoft.com/en-us/azure/cognitive-services/cognitive-services-apis-create-account
            String authenticationUrl = "https://api.cognitive.microsoft.com/sts/v1.0/issueToken";
            HttpsURLConnection authConn = (HttpsURLConnection) new URL(authenticationUrl).openConnection();
            authConn.setRequestMethod("POST");
            authConn.setDoOutput(true);
            authConn.setRequestProperty("Ocp-Apim-Subscription-Key", key);
            IOUtils.write("", authConn.getOutputStream(), "UTF-8");
            String token = IOUtils.toString(authConn.getInputStream(), "UTF-8");
            System.out.println(token);

//          Using the access token to build the appid for the request url
            String appId = URLEncoder.encode("Bearer " + token, "UTF-8");
            String text = URLEncoder.encode("Hello", "UTF-8");
            String from = "en";
            String to = "fr";
            String translatorTextApiUrl = String.format("https://api.microsofttranslator.com/v2/http.svc/GetTranslations?appid=%s&text=%s&from=%s&to=%s&maxTranslations=5", appId, text, from, to);
            HttpsURLConnection translateConn = (HttpsURLConnection) new URL(translatorTextApiUrl).openConnection();
            translateConn.setRequestMethod("POST");
            translateConn.setRequestProperty("Accept", "application/xml");
            translateConn.setRequestProperty("Content-Type", "text/xml");
            translateConn.setDoOutput(true);
            String TranslationOptions = "<TranslateOptions xmlns=\"http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2\">" +
                    "<Category>general</Category>" +
                    "<ContentType>text/plain</ContentType>" +
                    "<IncludeMultipleMTAlternatives>True</IncludeMultipleMTAlternatives>" +
                    "<ReservedFlags></ReservedFlags>" +
                    "<State>contact with each other</State>" +
                    "</TranslateOptions>";
            translateConn.setRequestProperty("TranslationOptions", TranslationOptions);
            IOUtils.write("", translateConn.getOutputStream(), "UTF-8");
            String resp = IOUtils.toString(translateConn.getInputStream(), "UTF-8");
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}