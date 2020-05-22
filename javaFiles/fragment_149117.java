@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = SexValidator.class)
@Documented
public @interface Sex
{

    String message() default "{customValidator.sex";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ FIELD, METHOD, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List
    {
        Sex[] value();
    }
}