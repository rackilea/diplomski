@Component
public class SecondaryValidator implements ConstraintValidator<ValidSecondary, UserDTO> {
    private Validator validator;

    public SecondaryValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (userDTO.isPrimary()) {
            return true;
        } else {
            return validator.validate(userDTO.getSecondaryDTO()).isEmpty();
        }
    }
}