@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = CombinedNotNullValidator.class)
public @interface CombinedNotNull {
   String message() default "username or email is required";
   Class<?>[] groups() default { };
   Class<? extends Payload>[] payload() default { };

   /** Fields to validate against null. */
   String[] fields() default { };
}