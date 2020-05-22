import com.google.appengine.api.appidentity.AppIdentityService;
import com.google.appengine.api.appidentity.AppIdentityServiceFactory;

// Get an access token to authorize export request
      ArrayList<String> scopes = new ArrayList<String>();
      scopes.add("https://www.googleapis.com/auth/datastore");
      final AppIdentityService appIdentity = AppIdentityServiceFactory.getAppIdentityService();
      final AppIdentityService.GetAccessTokenResult accessToken =
          AppIdentityServiceFactory.getAppIdentityService().getAccessToken(scopes);
      connection.addRequestProperty("Authorization", "Bearer " + accessToken.getAccessToken());