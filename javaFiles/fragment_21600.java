// obtain a validator
ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();

// do a test
Set<ConstraintViolation<User>> constraintViolations = validator.validate(user2);
Assert.assertEquals(0, constraintViolations.size());