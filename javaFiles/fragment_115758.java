import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValueValidator 
        implements ConstraintValidator<CustomAnnotation, SimpleDto> {

    @Override
    public void initialize(final CustomAnnotation constraintAnnotation) {
        // Extract any value you would need from the annotation
    }

    @Override
    public boolean isValid(final SimpleDto simpleDto, 
                           final ConstraintValidatorContext context) {
        boolean valid;

        // Some validations over the simpleDto

        if (!valid) {
            ((ConstraintValidatorContextImpl) context)
                    .addMessageParameter("wrongValue", simpleDto.toString());
        }

        return valid;
    }
}