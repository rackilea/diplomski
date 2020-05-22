@ExceptionHandler(MethodArgumentTypeMismatchException.class)
public void handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
    String name = ex.getName();
    String type = ex.getRequiredType().getSimpleName();
    Object value = ex.getValue();
    String message = String.format("'%s' should be a valid '%s' and '%s' isn't", 
                                   name, type, value);

    System.out.println(message);
    // Do the graceful handling
}