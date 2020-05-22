import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarRequestValidator implements 
                ConstraintValidator<RequestAnnotation, CarRequest> {

    @Override
    public void initialize(RequestAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(CarRequest value, ConstraintValidatorContext context) {
        // validation logic goes here
        return false;
    }
}