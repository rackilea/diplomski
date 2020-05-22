public interface ResponseErrorHandler {

    boolean hasError(ClientHttpResponse response) throws IOException;

    void handleError(ClientHttpResponse response) throws IOException;
}