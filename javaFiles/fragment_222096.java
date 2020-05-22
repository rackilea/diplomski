import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

class B2FileInfo {

    public void main(String[] args) throws Exception{
    String apiUrl = ""; // Provided by b2_authorize_account
    String fileId = ""; // The ID of the file you want to get info on
    String accountAuthorizationToken = ""; // Provided by b2_authorize_account
    HttpURLConnection connection = null;
    String postParams = "{\"fileId\":\"" + fileId + "\"}";
    byte postData[] = postParams.getBytes(StandardCharsets.UTF_8);
    try
    {
        URL url = new URL(apiUrl + "/b2api/v1/b2_get_file_info");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", accountAuthorizationToken);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Content-Length", Integer.toString(postData.length));
        connection.setDoOutput(true);
        DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
        writer.write(postData);
        String jsonResponse = myInputStreamReader(connection.getInputStream());
        System.out.println(jsonResponse);
    }catch(Exception e)
    {
        e.printStackTrace();
    }finally
    {
        connection.disconnect();
    }
    }

static public String myInputStreamReader(InputStream in) throws IOException {
    InputStreamReader reader = new InputStreamReader(in);
    StringBuilder sb = new StringBuilder();
    int c = reader.read();
    while (c != -1) {
        sb.append((char)c);
        c = reader.read();
    }
    reader.close();
    return sb.toString();
}
}