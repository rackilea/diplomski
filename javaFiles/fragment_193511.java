@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { ContainsKeyValidator.class })
public @interface ContainsKeys {
    String message() default "{com.acme.ContainsKey.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String[] value() default {};
}