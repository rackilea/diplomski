public static void main(String[] args) {

                String IntegratorKey = "[Your_Integrator_Key]";

                String ClientSecret = "[Your_Secret_Key]";

                String RedirectURI = "https://www.getpostman.com/oauth2/callback";//This REDIRECT_URI should match whats configured with IntegratorKey in your Sandbox account

                String AuthServerUrl = "https://account-d.docusign.com";

                String RestApiUrl = "https://demo.docusign.net/restapi";

                ApiClient apiClient = new ApiClient(AuthServerUrl, "docusignAccessCode", IntegratorKey, ClientSecret);

                apiClient.setBasePath(RestApiUrl);

                apiClient.configureAuthorizationFlow(IntegratorKey, ClientSecret, RedirectURI);

                Configuration.setDefaultApiClient(apiClient);

                String code = "{ENTER_AUTH_CODE_FROM_PREVIOUS_STEP}";
                apiClient.getTokenEndPoint().setCode(code);

                apiClient.registerAccessTokenListener(new AccessTokenListener() {
                    @Override
                    public void notify(BasicOAuthToken token) {
                        System.out.println("Got a fresh token: " + token.getAccessToken());
                    }
                });

                apiClient.updateAccessToken();
    }