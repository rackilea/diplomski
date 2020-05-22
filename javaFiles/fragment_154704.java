public class CrossThreadException extends Exception {

    public CrossThreadException( Throwable cause, StackTraceElement[] originalStackTrace ) {

        // No message, given cause, no supression, stack trace writable
        super( null, cause, false, true );

        setStackTrace( originalStackTrace );
    }
}