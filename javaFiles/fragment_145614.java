@RestControllerAdvice
public class CommonExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorDetail> handleConstraintViolationException(
      HttpServletRequest request, ConstraintViolationException base) {

    LOG.info("CONSTRAINT VIOLATION EXCEPTION: ", base);

    ErrorDetail error = new ErrorDetail<ConstraintViolationException>().setErrorDetails(
        CONSTRAINT_VIOLATION, base, "CONSTRAINT VIOLATION USERNAME ALREADY EXIST.");

    return new ResponseEntity<ErrorDetail>(error, HttpStatus.UNPROCESSABLE_ENTITY);

  }
}