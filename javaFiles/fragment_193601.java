import org.keycloak.admin.client.Keycloak;

import org.keycloak.representations.AccessTokenResponse;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component

public class KeycloakUtils {

   @Value("${toto.realm}")
   private String realm;

   @Value("${toto.client.id}")
   private String clientId;

   @Value("${toto.server.url}")
   private String serverUrl;

   @Value("${toto.user.name}")
   private String userName;

   @Value("${toto.password}")
   private String password;

   @Value("${toto.client.secret}")
   private String clientSecret;

   private Keycloak keycloak;


   public Keycloak getInstance() {
         if (keycloak == null) {
                keycloak = Keycloak.getInstance(serverUrl, realm, userName, password, clientId, clientSecret);
         }
         return keycloak;
   }


   public AccessTokenResponse getAccessToken() {
         return getInstance().tokenManager().grantToken();
   }