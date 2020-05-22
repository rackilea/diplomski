@Aspect
public class ServiceValidator{

    private Validator validator;

    public ServiceValidator() {
    }

    public ServiceValidator(Validator validator) {
        this.validator = validator;
    }

    public void doValidation(JoinPoint jp){
        for( Object arg : jp.getArgs() ){
            if (arg != null) {
                // uses hibernate validator
                Set<ConstraintViolation<Object>> violations = validator.validate(arg);
                if( violations.size() > 0 ){
                    // do something
                }
            }
        }
    }
}