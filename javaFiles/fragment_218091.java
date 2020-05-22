public final class MyBeanValidator implements
        ConstraintValidator<ValidMyBean, MyBean> {

    @Override
    public void initialize(
            @SuppressWarnings("unused") final ValidMyBean constraintAnnotation) {
    }

    @Override
    public boolean isValid(final MyBean value,
            final ConstraintValidatorContext context) {

        boolean isValid = true;
        //your validation here

        return isValid;
    }
}