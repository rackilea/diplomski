public class Token {
    @JsonProperty("access_token")
    private String accessToken;

    // other properties

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    // other getters and setters
}