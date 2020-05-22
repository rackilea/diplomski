@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(UserDuplicatedException.class)
    public ResponseEntity<Error> resolveAndWriteException(UserDuplicatedException e) throws IOException {
        Error error = new Error("571", e.getMessage());
        error.setErrors(//get your list or errors here...);
        return new ResponseEntity<Error>(error, HttpStatus.Select-Appropriate); 
    }
}