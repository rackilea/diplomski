public class CustomException extends Exception {
    /* Optional: Add Serial UID */

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}