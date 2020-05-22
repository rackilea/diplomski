@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = [ ConstraintViolationException.class ])
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    String handle(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations()
        StringBuilder strBuilder = new StringBuilder()
        for (ConstraintViolation<?> violation : violations ) {
            strBuilder.append(violation.getMessage() + "\n")
        }
        return strBuilder.toString()
    }
}