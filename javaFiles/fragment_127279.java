class StepExecutionException extends RuntimeException {
    StepExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    void raiseTicket() {
        // Code that raises the ticket ...
        // The message can be retrieved with getMessage().
        // The cause can be retrieved with getCause().
    }
}