ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();
Set<ConstraintViolation<User>> violations = validator.validate(object);
for (ConstraintViolation<User> violation : violations) {
log.error(violation.getMessage()); 
}