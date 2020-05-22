public class MatchFieldValidator implements ConstraintValidator<MatchField, Object> {

  private MatchField matchField;

  @Override
  public void initialize(MatchField matchField) {
    this.matchField = matchField;
  }

  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext cvc) {

    //do whatever you do
    if (validationFails) {
      cvc.buildConstraintViolationWithTemplate("YOUR FIRST ANSWER INPUT IS WRONG!!!").
                        addNode(matchField.firstAnswer()).addConstraintViolation();
      cvc.buildConstraintViolationWithTemplate("YOUR SECOND ANSWER INPUT IS WRONG!!!").
                        addNode(matchField.secondAnswer()).addConstraintViolation();
      //you get the idea
      cvc.disableDefaultConstraintViolation();
      return false;
    }
  }
}