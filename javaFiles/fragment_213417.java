import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

@SuppressWarnings("deprecation")
public class Postrequest {
    public static void postRequest(String attachmentValue) throws Exception {
        String attachment = "C:\\Users\\eclipse-workspace\\renamedfile\\"+attachmentValue;
        String url = "https://domain.egnyte.com/pubapi/v1/fs-content/Shared/a/Sa/Upload/"+attachmentValue;
        File inFile = new File(attachment);
        FileInputStream fis = null;
        FileBody data = new FileBody(inFile);
        try {
            fis = new FileInputStream(inFile);
            HttpClient httpclient = HttpClientBuilder.create().build();
            // server back-end URL
            HttpPost httppost = new HttpPost(url);
            httppost.addHeader("Authorization", "Bearer " + "*****");
            httppost.addHeader("Content-Disposition", "form-data; name=\"file\"");
            //httppost.addHeader("Content-type", "****");
            httppost.addHeader("Content-type", "text/plain");
            httppost.addHeader("Host", "domain.egnyte.com");
            MultipartEntityBuilder entity = MultipartEntityBuilder.create();
            entity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            entity.addPart("document", data);
            HttpEntity httpEntity = entity.build();
            httppost.setEntity(httpEntity);
            // execute the request
            HttpResponse response = httpclient.execute(httppost);
            int statusCode = response.getStatusLine().getStatusCode();
            Assert.assertEquals(statusCode, 200,"The Status code is not matched");
            HttpEntity responseEntity = response.getEntity();
            String responseString = EntityUtils.toString(responseEntity, "UTF-8");
            System.out.println("[" + statusCode + "] " + responseString);
        } catch (ClientProtocolException e) {
            System.err.println("Unable to make connection");
        } catch (IOException e) {
            System.err.println("Unable to read file");
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
            }
        }
    };