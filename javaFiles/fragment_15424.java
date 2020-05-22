@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    public final ResponseEntity<CustomError> handleException(MyException ex, WebRequest request) {
        CustomError error = new CustomError();            
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
    }
}