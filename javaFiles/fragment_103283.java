public class JoinPointException
extends Exception {
    private static final long serialVersionUID = 1;

    public JoinPointException(Throwable cause) {
        super(cause);
    }

    public JoinPointException(String message,
                              Throwable cause) {
        super(message, cause);
    }
}