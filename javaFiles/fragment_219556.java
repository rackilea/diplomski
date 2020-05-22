@RestControllerAdvice
public class ApplicationExceptionHandler {

   @ExceptionHandler(PasswordMismatchException.class)
   public ResponseEntity<String> handleBadPasswords(PasswordMismatchException e) {
       return ResponseEntity.badRequest().body(e.getMessage());
   }

}