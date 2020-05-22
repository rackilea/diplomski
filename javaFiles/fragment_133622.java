@Provider
public class Authenticator implements ClientRequestFilter {

    private String user;
    private String password;

    public Authenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add(
            HttpHeaders.AUTHORIZATION, getBasicAuthentication());
    }

    private String getBasicAuthentication() {
        String userAndPassword = this.user + ":" + this.password;
        byte[] userAndPasswordBytes = userAndPassword.getBytes("UTF-8");
        return "Basic " + Base64.getEncoder().encodeToString(userAndPasswordBytes);
    }
}