public class RestTemplateUtils {

    public static final RestTemplate template;
    static {
        // Init the RestTemplate here
        template = new RestTemplate();
    }

    /**
     * Add basic authentication to some {@link HttpHeaders}.
     * @param headers The headers to add authentication to
     * @param username The username
     * @param password The password
     */
    public static HttpHeaders addBasicAuth(HttpHeaders headers, String username, String password) {
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        String base64Creds = DatatypeConverter.printBase64Binary(plainCredsBytes);
        headers.add("Authorization", "Basic " + base64Creds);
        return headers;
    }
}