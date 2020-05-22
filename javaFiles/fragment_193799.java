public class NetworkAccessClass
{

    public interface ResponseHandler {
        void requestSucceeded(ResponseData responseData);
        void requestFailed(ErrorCode errorCode);
    }

    public NetworkAccessClass(
        String url,
        String methodName,
        Vector paramNames,
        Vector paramValues,
        ResponseHandler responseHandler) {
        // perform inits
    }

    public void run() {
        // Get Data
        try {
            ...
            responseHandler.requestSuceeded(responseData);
        catch() {
            responseHandler.requestFailed(errorCode);
        }
    }
}