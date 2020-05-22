Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
Set<ConstraintViolation<Car>> constraintViolations = validator.validate(myCar);

if (constraintViolations.size() > 0) {
    Set<String> violationMessages = new HashSet<String>();

    for (ConstraintViolation<T> constraintViolation : constraintViolations) {
        violationMessages.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
    }

    throw new RuntimeException("Car is not valid:\n" + StringUtils.join(violationMessages, "\n"));
}