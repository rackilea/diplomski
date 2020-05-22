public static <T> List<String> validate (T input) {
    List<String> errors = new ArrayList<>();
    Set<ConstraintViolation<T>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(input);
    if (violations.size() > 0) {
        for (ConstraintViolation<T> violation : violations) {
            errors.add(violation.getPropertyPath() + " " + violation.getMessage());
        }
    }
    return errors;
}