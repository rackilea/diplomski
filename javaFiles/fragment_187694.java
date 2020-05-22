public class KeyVaultTest {

    private static AuthenticationResult getAccessToken(String authorization, String resource) throws InterruptedException, ExecutionException, MalformedURLException {

        String clientId = "dc17****-****-****-****-ea03****a5e7"; // Client ID
        String clientKey = "1YWt******k21";  //Client Secret

        AuthenticationResult result = null;

        //Starts a service to fetch access token.
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(1);
            AuthenticationContext context = new AuthenticationContext(authorization, false, service);

            Future<AuthenticationResult> future = null;

            //Acquires token based on client ID and client secret.
            if (clientKey != null && clientKey != null) {
                ClientCredential credentials = new ClientCredential(clientId, clientKey);
                future = context.acquireToken(resource, credentials, null);
            }

            result = future.get();
        } finally {
            service.shutdown();
        }

        if (result == null) {
            throw new RuntimeException("Authentication results were null.");
        }
        return result;
    }

    public static void main(String[] args) {
        String vaultBase = "https://jackkv.vault.azure.net/";

        KeyVaultClient keyVaultClient = new KeyVaultClient(new KeyVaultCredentials(){
            @Override
            public String doAuthenticate(String authorization, String resource, String scope) {
                String token = null;
                try {
                    AuthenticationResult authResult = getAccessToken(authorization, resource);
                    token = authResult.getAccessToken();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return token;
            }
        });

        SecretBundle test = keyVaultClient.getSecret(vaultBase, "test");
        System.out.println(test.value());
    }
}