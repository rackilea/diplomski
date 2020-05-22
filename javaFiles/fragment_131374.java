@Component
public class MathValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return MatchRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MatchRequest request = (MatchRequest) o;

        if (request.getValue() == null) {
            errors.rejectValue("value", "Value cannot be empty");
        }
       //add another validation logic here.
    }
}