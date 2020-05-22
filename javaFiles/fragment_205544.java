@ControllerAdvice
public class GlobalValidationResponse extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<?> handleEntityNotFoundException(NotFoundException ex, HttpServletRequest request, HttpServletResponse response) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ValidationError(ex.getMessage()));

        }
}