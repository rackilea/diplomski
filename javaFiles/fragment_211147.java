@Constraint(validatedBy = AgeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface MaxAge {

/**
 * The age against which to validate.
 */
int value();

String message() default "com.mycompany.validation.MaxAge.message";
Class<?>[] groups() default {};
Class<? extends Payload>[] payload() default {};
}