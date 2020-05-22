import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Constraint(validatedBy = NoId.NoIdValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RUNTIME)
public @interface NoId {

    String message() default "Cannot have value for id attribute";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String idField() default "id";

    public static class NoIdValidator implements ConstraintValidator<NoId, Object> {
        private String idField;

        @Override
        public void initialize(NoId annotation) {
            idField = annotation.idField();
        }

        @Override
        public boolean isValid(Object bean, ConstraintValidatorContext cvc) {

            boolean isValid = false;
            try {
                Field field = bean.getClass().getDeclaredField(idField);
                if (field == null) {
                    isValid = true;
                } else {
                    field.setAccessible(true);
                    Object value = field.get(bean);
                    if (value == null) {
                        isValid = true;
                    }
                }
            } catch (NoSuchFieldException 
                    | SecurityException 
                    | IllegalArgumentException 
                    | IllegalAccessException ex) {
                Logger.getLogger(NoId.class.getName()).log(Level.SEVERE, null, ex);
            }
            return isValid;
        }
    }
}