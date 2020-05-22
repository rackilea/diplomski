package com.google.api.services.samples.dailymotion.cmdline;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import java.io.IOException;
import java.util.Arrays;


/**
 * A sample application that demonstrates how the Google OAuth2 library can be used to authenticate
 * against Google.
 *
 * @author Brad Parks
 */
public class GoogleAuthExample {

  // **********************************************************************
  // CHANGE THE FOLLOWING values to the keys you get after following the steps at the following page:
  // https://developers.google.com/accounts/docs/OAuth2Login#appsetup
  // This should be all you need to do to get this sample to work.
  // **********************************************************************
  public static final String API_KEY = "Enter your key here";
  public static final String API_SECRET = "Enter your key here";

  /** Directory to store user credentials. */
  private static final java.io.File DATA_STORE_DIR =
      new java.io.File(System.getProperty("user.home"), ".store/google_oauth_sample");

  /**
   * Global instance of the {@link DataStoreFactory}. The best practice is to make it a single
   * globally shared instance across your application.
   */
  private static FileDataStoreFactory DATA_STORE_FACTORY;

  /** OAuth 2 scope. */
  private static final String SCOPE = "openid email profile https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";

  /** Global instance of the HTTP transport. */
  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

  /** Global instance of the JSON factory. */
  static final JsonFactory JSON_FACTORY = new JacksonFactory();

  private static final String TOKEN_SERVER_URL = "https://accounts.google.com/o/oauth2/token";
  private static final String AUTHORIZATION_SERVER_URL = "https://accounts.google.com/o/oauth2/auth";
  public static final int PORT = 8080;
  public static final String DOMAIN = "127.0.0.1";


  /** Authorizes the installed application to access user's protected data. */
  private static Credential authorize() throws Exception {
    errorIfNotSpecified();

    AuthorizationCodeFlow flow = new AuthorizationCodeFlow.Builder(BearerToken
        .queryParameterAccessMethod(),
        HTTP_TRANSPORT,
        JSON_FACTORY,
        new GenericUrl(TOKEN_SERVER_URL),
        new ClientParametersAuthentication(
            API_KEY, API_SECRET),
        API_KEY,
        AUTHORIZATION_SERVER_URL).setScopes(Arrays.asList(SCOPE))
        .setDataStoreFactory(DATA_STORE_FACTORY).build();

    // authorize
    LocalServerReceiver receiver = new LocalServerReceiver.Builder().setHost(DOMAIN).setPort(PORT).build();
    return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
  }

  public static void errorIfNotSpecified() {
    if (API_KEY.startsWith("Enter ") || API_SECRET.startsWith("Enter ")) {
      System.out.println(
          "Enter API Key and API Secret from https://developers.google.com/accounts/docs/OAuth2Login#appsetup"
          + " into API_KEY and API_SECRET in " + GoogleAuthExample.class);
      System.exit(1);
    }
  }

  private static void run(HttpRequestFactory requestFactory) throws IOException {
    GenericUrl url = new GenericUrl("https://www.googleapis.com/oauth2/v1/tokeninfo");

    HttpRequest request = requestFactory.buildGetRequest(url);
    UserInfo userInfo = request.execute().parseAs(UserInfo.class);

    System.out.println("Got user info from API after authorization:");
    System.out.println("-----------------------------------------------");

    System.out.println("issued_to: " + userInfo.issued_to);
    System.out.println("audience: " + userInfo.audience);
    System.out.println("user_id: " + userInfo.user_id);
    System.out.println("scope: " + userInfo.scope);
    System.out.println("expires_in: " + userInfo.expires_in);
    System.out.println("email: " + userInfo.email);
    System.out.println("verified_email: " + userInfo.verified_email);
    System.out.println("access_type: " + userInfo.access_type);
  }

  public static void main(String[] args) {
    try {
      DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
      final Credential credential = authorize();
      HttpRequestFactory requestFactory =
          HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest request) throws IOException {
              credential.initialize(request);
              request.setParser(new JsonObjectParser(JSON_FACTORY));
            }
          });
      run(requestFactory);
      // Success!
      return;
    } catch (IOException e) {
      System.err.println(e.getMessage());
    } catch (Throwable t) {
      t.printStackTrace();
    }
    System.exit(1);
  }
}