public class ValidationsFatalException extends RuntimeException {
    private String message; 
    private Throwable cause;
    private List<String> details; 

    public ValidationsFatalException(String message, Throwable cause) {
        super(message, cause);
    } 

    public ValidationsFatalException(String message, Throwable cause, List<String> details) {
        super(message, cause); 
        this.details = details;
    }

    public List<String> getDetails() {
        return details; 
    }
}