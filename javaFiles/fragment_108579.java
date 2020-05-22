@Documented
@Constraint(validatedBy = NonZeroFloatValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NonZeroFloatConstraint {
    String message() default "Float value is zero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}