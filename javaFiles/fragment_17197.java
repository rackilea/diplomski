@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

@ExceptionHandler(value = { Exception.class })
protected ResponseEntity<Object> handleAllExcecption(Exception ex, WebRequest request) {
    // Do what ever you want. Log the error message, send notification etc
    return handleExceptionInternal(ex, logId.longValue(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
            request);
}