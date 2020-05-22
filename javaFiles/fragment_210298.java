@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumericValidator.class)
public @interface Numeric {

    String message() default "{constraint.postcode}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int digitCount() default -1;
}