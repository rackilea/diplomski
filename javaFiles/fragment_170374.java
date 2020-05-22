public static <T> String getValidationMessage(ConstraintViolation<T> violation) {
    String className = violation.getRootBeanClass().getSimpleName();
    String property = violation.getPropertyPath().toString();
    //Object invalidValue = violation.getInvalidValue();
    String message = violation.getMessage();
    return String.format("%s.%s %s", className, property, message);
}