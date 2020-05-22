@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(checkWith = MaxCheck.class)
public @interface Max {

    String message() default MaxCheck.mes;
    double value();
}