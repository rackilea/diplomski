public class LogResponseErrorHandler implements ResponseErrorHandler {
...
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        logResponse(response.getBody());
    }
...
}