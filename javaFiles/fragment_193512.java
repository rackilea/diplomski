public class ContainsKeysValidator implements ConstraintValidator<ContainsKeys, Map<?, ?>> {

    String[] requiredKeys;

    @Override
    public void initialize(ContainsKeys constraintAnnotation) {
        requiredKeys = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Map<?, ?> value, ConstraintValidatorContext context) {
        if( value == null ) {
            return true;
        }

        for( String requiredKey : requiredKeys ) {
            if( value.containsKey( requiredKey ) ) {
                return false;
            }
        }

        return true;
    }
}