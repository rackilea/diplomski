public class AppException extends Exception {
    public static AppException logAndThrow(Logger logger, String message) throws AppException {
        AppException e = new AppException(message);
        // log the stack trace as well
        logger.error(message, e);
        throw e;
    }
}