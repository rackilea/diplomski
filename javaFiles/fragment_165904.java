public class NotEmptyTest {
    @Test
    public void firstTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        NotEmptyClass obj = new NotEmptyClass(null);

        // Validate the object
        Set<ConstraintViolation<NotEmptyClass>> constraintViolations = validator.validate(obj);

        // This is the line that will cause your unit test to fail if there are not any violations
        Assert.assertEquals(1, constraintViolations.size());
    }
}