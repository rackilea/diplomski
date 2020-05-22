@ControllerAdvice
public class BWSExceptionHandler extends ResponseEntityExceptionHandler {
  ...
  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
      MissingServletRequestParameterException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
      // MissingServletRequestParameterException handling code goes here.
  }
  ...
  @ExceptionHandler(value = { Exception.class } )
  public ResponseEntity<Object> handleOtherExceptions(final Exception ex, 
    final WebRequest req) {
    ...
  }

}