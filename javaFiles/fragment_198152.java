import com.google.api.client.util.Base64;
    import com.google.auth.oauth2.ServiceAccountCredentials;
    import java.io.DataOutputStream;
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.io.InputStream;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.net.URLEncoder;
    import javax.ws.rs.client.Client;
    import javax.ws.rs.client.ClientBuilder;
    import javax.ws.rs.client.Entity;
    import javax.ws.rs.client.ResponseProcessingException;
    import javax.ws.rs.core.Response;
    import uploader.Utilities;

    public class Uploader {

      private ServiceAccountCredentials creds;    // Service Account Credentials
      private String saEmail;                     // Service Account email

      public Uploader() {
        /* Initialize credentials and service account email*/
        try (InputStream inputStream = new FileInputStream("C:/cred/Key.json")) {
          this.creds = ServiceAccountCredentials.fromStream(
              inputStream);
        } catch (IOException e) {
          e.printStackTrace();
        }
        this.saEmail = "service account email";
      }

      /* Sign and return the URL for POST, using credentials from above*/
      private String getSignedUrl(String bucketName, String objectName, String mimeType) {
        String signed_url = null;
        try {
          String verb = "POST";
          long expiration = System.currentTimeMillis() / 1000 + 60;
          String Canonicalized_Extension_Headers = "x-goog-resumable:start";
          String content_type = mimeType;

          byte[] sr = creds.sign(
              (verb + "\n\n" + content_type + "\n" + expiration + "\n" + Canonicalized_Extension_Headers
                  +
                  "\n" + "/" + bucketName + "/" + objectName).getBytes());
          String url_signature = new String(Base64.encodeBase64(sr));
          signed_url = "https://storage.googleapis.com/" + bucketName + "/" + objectName +
              "?GoogleAccessId=" + saEmail +
              "&Expires=" + expiration +
              "&Signature=" + URLEncoder.encode(url_signature, "UTF-8");
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        return signed_url;
      }


      /* Send POST request to the signed URL using custom headers and an empty body, which returns the actual upload location */
      public String getLocation(String bucketName, String objectName, String mimeType)
          throws IOException {
        URL myURL = new URL(getSignedUrl(bucketName, objectName, mimeType));
        HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();
        myURLConnection.setRequestMethod("POST");
        myURLConnection.setRequestProperty("Content-Type", mimeType);
        myURLConnection.setRequestProperty("x-goog-resumable", "start");
        // Send post request
        myURLConnection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(myURLConnection.getOutputStream());
        wr.flush();
        wr.close();
        int responseCode = myURLConnection.getResponseCode();
        if (responseCode != 201) {
          System.out.println("Request Failed");
        }
        return myURLConnection.getHeaderField("Location");            
      }

      /* Do the actual upload and return the PUT Response*/
     public Response doUpload(String url, InputStream inputStream, String mimeType) {
        Response response = null;
        Client client = ClientBuilder.newClient();
        try {
          response = client.target(url)
              .request()
              .put(Entity.entity(inputStream, mimeType));
          if (response.getStatus() != 200) {
            System.out.println("Request failed with " + response.getStatus());
          }
        } catch (ResponseProcessingException e) {
          e.printStackTrace();
        }
        return response;
      }   

    }