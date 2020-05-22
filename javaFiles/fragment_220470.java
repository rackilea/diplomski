public boolean isValid(String vehicleName, ConstraintValidatorContext constraintValidatorContext) {
    boolean isValid = false;
    if ( constraintValidatorContext instanceof HibernateConstraintValidatorContext ) {
        final String payload = constraintValidatorContext
                .unwrap( HibernateConstraintValidatorContext.class )
                .getConstraintValidatorPayload( String.class );
        // do whatever you need
        isValid = logicmethod()//some logic here
    }
    return isValid;
}