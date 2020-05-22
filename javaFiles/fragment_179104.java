@EnableOAuth2Client
@Configuration
public class KeycloakConfiguration {

//  token-service-uri=https://keycloak.internal/auth/realms/some-realm/protocol/openid-connect/token
//  admin-query.client-id=client
//  admin-query.username=service-account
//  admin-query.password=password
//  admin-query.admin-base-url=https://keycloak.internal/auth/admin/realms/realm

@Value("${token-service-uri}")
private String tokenServiceUri;

@Value("${admin-query.client-id}")
private String clientId;

@Value("${keycloak.credentials.secret}")
private String clientSecret;

@Value("${admin-query.username}")
private String username;

@Value("${admin-query.password}")
private String password;


private final String grantType = "password";


@Bean
public OAuth2ProtectedResourceDetails cryptoKeycloakResourceDetails() {

    ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
    details.setAccessTokenUri(tokenServiceUri);
    details.setClientId(clientId);
    details.setClientSecret(clientSecret);
    details.setGrantType(grantType);
    details.setUsername(username);
    details.setPassword(password);

    return details;
}


@Bean
public OAuth2RestTemplate cryptoKeycloakRestTemplate(OAuth2ClientContext clientContext) throws Exception {

    // build template with custom SSL TrustStrategy

    TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
    SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
            .loadTrustMaterial(null, acceptingTrustStrategy)
            .build();
    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

    CloseableHttpClient httpClient = HttpClients.custom()
            .setSSLSocketFactory(csf)
            .build();

    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(httpClient);

    AuthorizationCodeAccessTokenProvider authCodeAccessTokenProvider = new AuthorizationCodeAccessTokenProvider();
    authCodeAccessTokenProvider.setRequestFactory(requestFactory);

    ImplicitAccessTokenProvider implicitAccessTokenProvider = new ImplicitAccessTokenProvider();
    implicitAccessTokenProvider.setRequestFactory(requestFactory);

    ResourceOwnerPasswordAccessTokenProvider resourceOwnerTokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
    resourceOwnerTokenProvider.setRequestFactory(requestFactory);

    ClientCredentialsAccessTokenProvider clientCredentialsTokenProvider = new ClientCredentialsAccessTokenProvider();

    AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(
            Arrays.<AccessTokenProvider> asList(authCodeAccessTokenProvider, implicitAccessTokenProvider,
                    resourceOwnerTokenProvider, clientCredentialsTokenProvider));

    AccessTokenRequest request = new DefaultAccessTokenRequest();
    OAuth2RestTemplate template = new OAuth2RestTemplate(cryptoKeycloakResourceDetails(), new DefaultOAuth2ClientContext(request));
    template.setAccessTokenProvider(accessTokenProvider);
    template.setRequestFactory(requestFactory);
    return template;
}
}



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class KeycloakAdminQueryService {

@Autowired
private OAuth2RestOperations cryptoKeycloakRestTemplate;

@Value("${admin-query.admin-base-url}")
private String keycloakAdminQueryBaseUrl;

public KeycloakUserProfile getUserProfile(final String userId) 
        throws UserProfileNotFoundException {

    Map<String,Object> uriVars = new HashMap<String,Object>();
    uriVars.put("userId", userId);

    try {
        ResponseEntity<KeycloakUserProfile> response = cryptoKeycloakRestTemplate.getForEntity(
                keycloakAdminQueryBaseUrl + "/users/{userId}", KeycloakUserProfile.class, uriVars);
        return response.getBody();

    } catch (HttpClientErrorException e) {
        if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new UserProfileNotFoundException("Keycloak could not find user: " + userId, e);
        } else {
            throw e;
        }
    } 
}
}



@Data
public class KeycloakUserProfile {

private String id;
private String createdTimestamp;
private String username;
private boolean enabled;
private boolean totp;
private boolean emailVerified;
private String firstName;
private String lastName;
private String email;
private List<String> disableableCredentialTypes;
private List<String> requiredActions;
private int notBefore;
private Access access;


@Data
public static class Access {
    private boolean manageGroupMembership;
    private boolean view;
    private boolean mapRoles;
    private boolean impersonate;
    private boolean manage;
}

}