@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyBeanValidator.class)
public @interface ValidMyBean {

    boolean allViolationMessages() default true;

    Class<?>[] constraints() default {};

    Class<?>[] groups() default {};

    String message() default "{ValidMyBean.message}";

    Class<? extends Payload>[] payload() default {};
}