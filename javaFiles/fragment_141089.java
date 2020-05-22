public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    if ( value == null ) {
        return true;
    }
    Matcher m = pattern.matcher( value );
    return m.matches();
}