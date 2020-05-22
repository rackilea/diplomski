@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { NotEmptyValidator.class })
public @interface NotEmpty {

    String message() default "{customMessage} is required.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String customMessage() default "";
}

public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String>
{
    @Override
    public void initialize(NotEmpty notEmpty)
    {        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        return value != null && !value.isEmpty();
    }
}