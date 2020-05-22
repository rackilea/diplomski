interface LoggableException {
    void logToFile();
}
public class CustomExceptionOne extends Exception implements LoggableException {
    ...
    public void logToFile() {
        // Do something
    }
}
public class CustomExceptionTwo extends Exception implements LoggableException {
    ...
    public void logToFile() {
        // Do something else
    }
}
public void processException(Exception ex) {
    if (ex instanceof LoggableException) {
        LoggableException lEx = (LoggableException)ex;
        lEx.logToFile();
    }
}