import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
public class test {

public static void main(String[] args) throws Exception {

    String repository_name = "";
    String r_object_id = "";

    JSONObject theObject = makeRequest("http://localhost:8000/dctm-rest/repositories/"
            + repository_name + "/objects/" + r_object_id);

    if (theObject != null) {

        // you have all information about the object now
        // you can access the attributes of the object by
        // theObject.getJSONObject("properties") then like
        // .getString("object_name")

        JSONObject contentJSON = makeRequest("http://localhost:8000/dctm-rest/repositories/"
                + repository_name
                + "/objects/"
                + r_object_id
                + "/contents/content");

        JSONArray js = contentJSON.getJSONArray("links");
        for (int i = 0; i < js.length(); i++) {
            JSONObject jo = js.getJSONObject(i);
            if (jo.has("title") && "ACS".equals(jo.getString("title"))) {

                // here is your byte array
                byte[] bytes = getAsByteArray(new URL(jo.getString("href")))
                        .array();

            }
        }
    }

}

public static JSONObject makeRequest(String url) {

    JSONObject json = null;

    String username = "";
    String password = "";

    String strResponse = "";

    CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    BufferedReader rd = null;
    CloseableHttpResponse cls = null;

    HttpGet request = new HttpGet(url);

    RequestConfig config = RequestConfig.custom()
            .setSocketTimeout(120 * 1000).setConnectTimeout(30 * 1000)
            .setConnectionRequestTimeout(30 * 1000).build();

    request.setConfig(config);

    request.addHeader("Accept", "application/vnd.emc.documentum+json");

    request.addHeader(
            "Authorization",
            "Basic "
                    + com.documentum.xmlconfig.util.Base64.encode(username
                            + ":" + password));

    try {

        cls = httpClient.execute(request);

        HttpEntity entity = cls.getEntity();

        rd = new BufferedReader(new InputStreamReader(entity.getContent()));
        String line = "";
        while (line != null) {
            line = rd.readLine();
            strResponse += line;
        }

        strResponse = strResponse.trim().replace("\n", "");

        String statusline = cls.getStatusLine().toString();
        if (!statusline.contains("200") && !statusline.contains("201")) {

            System.out.println(strResponse);

        } else {

            json = new JSONObject(strResponse);
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    return json;

}

public static ByteBuffer getAsByteArray(URL url) throws IOException {
    URLConnection connection = url.openConnection();
    // Since you get a URLConnection, use it to get the InputStream
    InputStream in = connection.getInputStream();
    // Now that the InputStream is open, get the content length
    int contentLength = connection.getContentLength();

    // To avoid having to resize the array over and over and over as
    // bytes are written to the array, provide an accurate estimate of
    // the ultimate size of the byte array
    ByteArrayOutputStream tmpOut;
    if (contentLength != -1) {
        tmpOut = new ByteArrayOutputStream(contentLength);
    } else {
        tmpOut = new ByteArrayOutputStream(16384); // Pick some appropriate
                                                    // size
    }

    byte[] buf = new byte[512];
    while (true) {
        int len = in.read(buf);
        if (len == -1) {
            break;
        }
        tmpOut.write(buf, 0, len);
    }
    in.close();
    tmpOut.close(); // No effect, but good to do anyway to keep the metaphor
                    // alive

    byte[] array = tmpOut.toByteArray();

    // Lines below used to test if file is corrupt
    // FileOutputStream fos = new FileOutputStream("C:\\abc.pdf");
    // fos.write(array);
    // fos.close();

    return ByteBuffer.wrap(array);
}