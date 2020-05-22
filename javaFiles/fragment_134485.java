@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ChekingCredentialsFailedException.class)
    public ResponseEntity handleException(ChekingCredentialsFailedException e) {
        // log exception
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Error Message");
    }        
}