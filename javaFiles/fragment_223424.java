import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage {

    @JsonProperty
    private final String message;

    @JsonProperty
    private final String requestURI;

    public ErrorMessage(String message, String requestURI) {
        this.message = message;
        this.requestURI = requestURI;
    }
}