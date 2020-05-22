@ControllerAdvice
public class GameLostExceptionHandler {

   @ExceptionHandler({GameLostException.class})
   public ResponseEntity<CustomError> gameLostHandler(GameLostException e) {
      return new ResponseEntity<>(new CustomError("Game lost"), HttpStatus.OK);
   }
}