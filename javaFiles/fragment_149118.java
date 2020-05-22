public class SexValidator implements ConstraintValidator<Sex, Character> {

    public void initialize(Sex sex)
    {
        // used only if your annotation has attributes
    }

    public boolean isValid(Character sex, ConstraintValidatorContext constraintContext)
    {
        // Bean Validation specification recommends to consider null values as
        // being valid. If null is not a valid value for an element, it should
        // be annotated with @NotNull explicitly.
        if (sex == null)
        {
            return true;
        }
        if (sex.equals('F') || sex.equals('M'))
            return true;

        else
        {
            return false;
        }

    }
}