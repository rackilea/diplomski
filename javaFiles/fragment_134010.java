@POST
public Response getTest(TestRest testRest) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    Set<ConstraintViolation<TestRest>> constraintViolations = validator.validate(testRest);
    System.out.println(constraintViolations.size());

    return Response.status(Response.Status.OK).entity(constraintViolations.size()).build();
}