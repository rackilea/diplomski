@ControllerAdvice
class MyExceptionHandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
   HttpHeaders headers, HttpStatus status, WebRequest request) {
     // read ex.getBindingResult().
     return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
  }