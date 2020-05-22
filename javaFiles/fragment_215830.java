@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ChoiceValidator.class)
@Documented
public @interface Choice {

    String[] fields();

    String message() default "{Choice.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}