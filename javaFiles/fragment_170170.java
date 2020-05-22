public class DefaultException extends RuntimeException {

    private String errorCode;

    public DefaultException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    // ...
}