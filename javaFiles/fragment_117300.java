package ${package_name_same_as_library_class};

public class DateInFutureValidator implements ConstraintValidator<DateInFuture, Temporal> {
  @Override
  public void initialize(DateInFuture constraintAnnotation) { }

  @Override
  public boolean isValid(Temporal value, ConstraintValidatorContext context) {
    return true;
  }
}