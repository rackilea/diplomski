public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

  private String firstFieldName;
  private String secondFieldName;

  @Override
  public void initialize(final FieldMatch constraintAnnotation) {
    firstFieldName = constraintAnnotation.first();
    secondFieldName = constraintAnnotation.second();
  }

  @Override
  public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    try {
      final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
      final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

      boolean isValid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);

      if (!isValid) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addNode(secondFieldName).addConstraintViolation();
      }

      return isValid;
    }
    catch (final Exception ignore) {
      // ignore
    }
    return true;
  }
}