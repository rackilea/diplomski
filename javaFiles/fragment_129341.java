import com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
...

/** The API Key of the project */
private static final String API_KEY = "the_api_key_of_the_project";

/**
 * Build and returns a Drive service object authorized with the
 * application's service accounts.
 *
 * @return Drive service object that is ready to make requests.
 */
public static Drive getDriveService() throws GeneralSecurityException,
    IOException, URISyntaxException {
  HttpTransport httpTransport = new NetHttpTransport();
  JsonFactory jsonFactory = new JacksonFactory();
  AppIdentityCredential credential =
      new AppIdentityCredential.Builder(DriveScopes.DRIVE).build();
  GoogleClientRequestInitializer keyInitializer =
      new CommonGoogleClientRequestInitializer(API_KEY);
  Drive service = new Drive.Builder(httpTransport, jsonFactory, null)
      .setHttpRequestInitializer(credential)
      .setGoogleClientRequestInitializer(keyInitializer)
      .build();
  return service;
}