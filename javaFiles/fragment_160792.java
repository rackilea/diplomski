public class CustomWebServiceTemplate extends WebServiceTemplate{

    @Override
    protected Object handleError(WebServiceConnection connection, WebServiceMessage request) throws IOException {
        log.info("Log the error case in here");
        return super.handleError(connection, request);
    }
}