@Test
public void testBindingResult(BindingResult result,Set<ConstraintViolation<String>> violations){
    for (  ConstraintViolation<String> constraintViolation : violations) {
        ObjectError error=new ObjectError("object",constraintViolation.getMessage());
        result.addError(error);
    }
}