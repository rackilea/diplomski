Sample test = new Sample();
test.preco = 11.12f;

ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();
Set<ConstraintViolation<Sample>> violations = validator.validate(test);

for (final ConstraintViolation<Sample> cons : violations) {
        System.out.println(cons.getMessage());
}