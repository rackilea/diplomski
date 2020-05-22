@Component
public class CustomBeanValidatorImpl implements CustomBeanValidator {
    ValidatorFactory valdiatorFactory = null; 

    public CustomBeanValidatorImpl() {
        valdiatorFactory = Validation.buildDefaultValidatorFactory(); 
    }

    @Override
    public <T> void validateFields(T object) throws ValidationsFatalException {
        Validator validator = valdiatorFactory.getValidator(); 
        Set<ConstraintViolation<T>> failedValidations = validator.validate(object); 

        if (!failedValidations.isEmpty()) {
            List<String> allErrors = failedValidations.stream().map(failure -> failure.getMessage())
                    .collect(Collectors.toList());
            throw new ValidationsFatalException("Validation failure; Invalid request.", allErrors);
        }
    }
}