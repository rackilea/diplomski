@Pattern(regexp = Constants.LOGIN_PATTERN)
@Size(min = 4, max = 50)
@Constraint(validatedBy = {})
@Target(value = { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {

    String message() default "Incorrect login";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}