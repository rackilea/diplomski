public class MyListSizeValidator implements
        ConstraintValidator<MyListConstraintAnnotation, List<?> /* list of any type */ > {

    public void initialize(MyListConstraintAnnotation myannotation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isValid(List<?> mylist, ConstraintValidatorContext constraintValidatorContext) {
        return mylist.size() < 4;
    }
}

@Documented
@Constraint(validatedBy = MyListSizeValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyListConstraintAnnotation {
    String message() default "List is full!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}