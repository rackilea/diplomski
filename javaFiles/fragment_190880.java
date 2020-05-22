@RestControllerAdvice
@RequestMapping(produces = "application/json")
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    // This method handles constraint violation exception raised by DB. 
    // Similarly other type exceptions like custom exception and HTTP status related 
    //exception can be handled here.
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public Map<String, String> handleConstraintViolationException(ConstraintViolationException ex) {
    // write your own logic to return user friendly response 
   }

   // Below method is to handle _SqlExceptionHelper_ exception
    @ExceptionHandler(SqlExceptionHelper.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public Map<String, String> handleConstraintViolationException(SqlExceptionHelper ex) {
    // write your own logic to return user friendly response 
   }



}