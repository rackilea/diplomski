@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = FloatValidator.class)
@Documented
public @interface FloatPattern {

    String message() default "Float contraint voilated";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}