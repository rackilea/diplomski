public class AgeConstraintValidator implements ConstraintValidator<MaxAge, Integer> {

private int maximumAge;

@Override
public void initialize(MaxAge constraintAnnotation) {
    this.maximumAge = constraintAnnotation.value();
}

@Override
public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if (value == null) {
        return true;
    }

    return value.intValue() <= this.maximumAge;
}

}