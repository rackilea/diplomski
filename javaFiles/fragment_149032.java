@Constraint(validatedBy = TenantValidator.class) // Your validator class
@Target({ TYPE, ANNOTATION_TYPE }) // Static import from ElementType, change this to METHOD/FIELD if you want to create a validator for a single field (rather than a cross-field validation)
@Retention(RUNTIME) // Static import from RetentionPolicy
@Documented
public @interface ValidTenant {
    String message() default "{ValidTenant.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}