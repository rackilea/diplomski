public abstract class TokenServerResponse<T> {
    private String responseCode;
    private String responseMessage;
    private T responseData;

    public T getResponseData() {
        return responseData;
    }
}

public class TokenServerResponseDigestResponseData extends TokenServerResponse<DigestResponseData> {

}