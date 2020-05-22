import com.google.appengine.api.appidentity.AppIdentityService;
import com.google.appengine.api.appidentity.AppIdentityServiceFactory;
import com.google.auth.appengine.AppEngineCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;

AppIdentityService appIdentityService = AppIdentityServiceFactory.getAppIdentityService();
GoogleCredentials credentials = AppEngineCredentials.newBuilder().setAppIdentityService(appIdentityService).build();
storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();