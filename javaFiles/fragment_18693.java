public class InvalidCredentialException extends RuntimeException {

private static final long serialVersionUID = -3338166707608147652L;
private int errorCode;

public InvalidCredentialException() {

}

public InvalidCredentialException(final Throwable cause) {
    super(cause);
}

public InvalidCredentialException(final String message) {
    super(message);
}

public InvalidCredentialException(final int errorCode, final String message) {
    super(message);
    this.setErrorCode(errorCode);
}

public InvalidCredentialException(final String message, final Throwable cause) {
    super(message, cause);
}

public int getErrorCode() {
    return errorCode;
}}