@Documented
@Retention(RUNTIME)
@Target({ANNOTATION_TYPE, TYPE})
@Constraint(validatedBy = SecondaryValidator.class)
public @interface ValidSecondary {
    String message() default "Invalid secondary";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}