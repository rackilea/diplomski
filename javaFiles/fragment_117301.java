public class ClientKerberosAuthentication {

    public static void main(String[] args) throws Exception {

        System.setProperty("java.security.auth.login.config", "login.conf");
        System.setProperty("java.security.krb5.conf", "krb5.conf");
        System.setProperty("sun.security.krb5.debug", "true");
        System.setProperty("javax.security.auth.useSubjectCredsOnly","false");

        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            httpclient.getAuthSchemes().register(AuthPolicy.SPNEGO, new SPNegoSchemeFactory());

            Credentials use_jaas_creds = new Credentials() {

                public String getPassword() {
                    return null;
                }

                public Principal getUserPrincipal() {
                    return null;
                }

            };

            httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(null, -1, null),
                    use_jaas_creds);

            HttpUriRequest request = new HttpGet("http://kerberoshost/");
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println("----------------------------------------");
            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }
            System.out.println("----------------------------------------");

            // This ensures the connection gets released back to the manager
            EntityUtils.consume(entity);

        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }

}