@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler({SQLException.class})
public ResponseEntity<Object> sqlError(Exception ex) {
  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some SQL exception occured");
}
}