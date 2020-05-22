public class UpdateALM {    
    private static final String qcbinURI = "https://alm_url/qcbin";
    private static final String isAuthenticatedPath = "rest/is-authenticated";
    private static final String logoutPath = "authentication-point/logout";
    private static final String domainsPath = "rest/domains";
    private static Cookie cookie;

    private String getEncodedAuthString() {
        String auth = strUserName + ":" + strPassword;
        byte[] encodedAuth = Base64.encode(auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);

        return authHeader;
    }

    public boolean isAuthenticated() {
        target = client.target(qcbinURI).path(isAuthenticatedPath);
        invocationBuilder = target.request(new String[] { "application/xml" });
        invocationBuilder.cookie(cookie);
        Response res = invocationBuilder.get();
        return res.getStatus() == 200;
    }

    public void updateALMStatus() throws Exception {
        try {           
            target = client.target(
                    "https://alm_url/qcbin").path(
                    "authentication-point/authenticate");
            invocationBuilder = target.request("text", "plain");
            invocationBuilder.header("Authorization", getEncodedAuthString());

            res = invocationBuilder.get();
            cookie = ((Cookie) res.getCookies().get("LWSSO_COOKIE_KEY"));

            getTestSet(test_set);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}