@Test
public void simpleTest(){
    ValidatorOneValidator validator = new ValidatorOneValidator(); //Class response for validation in ValidatorOne
    MyClass myClass = givenAValidMyClass(); //Some fixture

    validator.initialize(myClass.getClass().getAnnotation(ValidMyClass.class).annotationType().getAnnotation(ValidatorOne.class));

    assertTrue(validator.isValid(myClass, null));
}