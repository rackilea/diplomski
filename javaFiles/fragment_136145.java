@ControllerAdvice
@RestController
public class customExceptionAdvice {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity handleConflict(BadRequestException e, HttpServletResponse response)
      throws IOException {

    return new ResponseEntity(e.getErrorBody(), HttpStatus.BAD_REQUEST);
  }