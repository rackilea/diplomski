@ExceptionHandler(value = { ConstraintViolationException.class })
 @ResponseStatus(value = HttpStatus.BAD_REQUEST)
 public String handleResourceNotFoundException(ConstraintViolationException e) {
      Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
      StringBuilder strBuilder = new StringBuilder();
      for (ConstraintViolation<?> violation : violations ) {
           strBuilder.append(violation.getMessage() + "\n");
      }
      return strBuilder.toString();
 }