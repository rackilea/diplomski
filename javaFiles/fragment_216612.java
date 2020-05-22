@javax.validation.Constraint(validatedBy = { PhoneNumberConstraintValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface ValidPhoneNumber {
}

public class PhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, Long> {
    @Override
    public void initialize(final ValidPhoneNumber constraintAnnotation) {
        // nop
    }
    @Override
    public boolean isValid(final Long value, final ConstraintValidatorContext context) {
       //your custom validation logic 
    }
}

class employee{
...
private long phone;

@ValidPhoneNumber
public Long getPhone() { return phone; } 
...
}