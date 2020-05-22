import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.fileupload.util.Streams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    public static String getResponse(String url) throws IOException {
        return getResponse(url, "UTF-8");
    }

    public static String getResponse(String url, String characterEncoding) throws IOException {
        return getByteArrayOutputStream(url).toString(characterEncoding);
    }

    public static byte[] getBytes(String url) throws IOException {
        return getByteArrayOutputStream(url).toByteArray();
    }

    public static ByteArrayOutputStream getByteArrayOutputStream(String url) throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        HttpResponse response = httpclient.execute(httpGet);
        LOGGER.debug("Status Line: " + response.getStatusLine());
        HttpEntity resEntity = response.getEntity();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Streams.copy(resEntity.getContent(), byteArrayOutputStream, true);
        return byteArrayOutputStream;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getResponse("https://www.reddit.com/r/AskReddit/.json"));
    }

}