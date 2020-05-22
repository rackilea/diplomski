public class SwaggerAuthenticationResponse {

    private final String access_token;

    public SwaggerAuthenticationResponse(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return this.access_token;
    }
}