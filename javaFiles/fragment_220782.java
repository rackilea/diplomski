/*  ----- Using the Hibernate Validator implementation ----- */
@Test
public void testInvalidCount() throws Exception {
    final String json = "{\"count\":-10, \"name\":\"Stack\"}";
    ObjectMapper mapper = new ObjectMapper();
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    SimpleFooRequest request = mapper.readValue(
                               json, SimpleFooRequest.class);
    Set<ConstraintViolation<SimpleFooRequest>> violations 
                             = validator.validate(request);
    Assert.assertEquals(1, violations.size());  
    Assert.assertEquals("must be min 10", 
            violations.iterator().next().getMessage());
}