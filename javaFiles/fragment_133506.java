import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.json.gson.GsonFactory;
import java.io.File;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import java.util.Arrays;
import com.google.api.services.calendar.Calendar;

GoogleCredential credentials = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
  .setJsonFactory(new GsonFactory())
  .setServiceAccountId("<service account email address>@developer.gserviceaccount.com")
  .setServiceAccountScopes(Arrays.asList("https://www.googleapis.com/auth/calendar.readonly"))
  .setServiceAccountPrivateKeyFromP12File(new File("<private key for service account in P12 format>-privatekey.p12"))
.build();
Calendar client = new Calendar.Builder(GoogleNetHttpTransport.newTrustedTransport(), new GsonFactory(), credentials).build();
client.<do calendar stuff>.execute();