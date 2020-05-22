import java.lang.annotation.*;
import javax.validation.*;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ComboBoxValidator.class)
@Documented
public @interface ValidComboBox {
String value = "Please select a security question";

String message() default "Please select a security question.";

Class<?>[]groups() default {};

Class<? extends Payload>[]payload() default {};
}