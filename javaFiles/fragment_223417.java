@Test
public void getAccessTokenViaSpringSecurityOAuthClient() {
    try{

        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setClientSecret(TestOAuthConstants.CLIENT_SECRET);
        resourceDetails.setClientId(TestOAuthConstants.CLIENT_ID);
        resourceDetails.setAccessTokenUri(TestOAuthConstants.TOKEN_REQUEST_URL);
        resourceDetails.setScope(TestOAuthConstants.SCOPES);

        OAuth2RestTemplate oAuthRestTemplate = new OAuth2RestTemplate(resourceDetails);

        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON );

        OAuth2AccessToken token = oAuthRestTemplate.getAccessToken();
        System.out.println(oAuthRestTemplate.getResource());
        System.out.println(oAuthRestTemplate.getOAuth2ClientContext());
        System.out.println(token);

        assertTrue(token != null);

    } catch (Exception e) {
        e.printStackTrace();
    }
}