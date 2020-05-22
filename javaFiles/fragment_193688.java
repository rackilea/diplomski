@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUnexpectedException(UnexpectedException 
                     unExpectedExe) {

        //log and send the response back to the client here
    }
}