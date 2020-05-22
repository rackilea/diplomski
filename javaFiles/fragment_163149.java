@Override
public boolean isValid(final List<String> value,
        final ConstraintValidatorContext constraintContext) {
    boolean valid = true;
    if (null != value && value.size() != EMPTY_SIZE) {
        ShortCodeValidator validator = new ShortCodeValidator();    
        for(String shortCode: value) {
            result &= validator.isValid(shortCode);
        }
    }
    return valid;
}