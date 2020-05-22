import javax.validation.*;
public class ComboBoxValidator implements ConstraintValidator<ValidComboBox, String> {

private String value;

@Override
public void initialize(ValidComboBox arg0) {
    this.value = arg0.value;

}

@Override
public boolean isValid(String question, ConstraintValidatorContext arg1) {
    if(question.equalsIgnoreCase(value)){
        return false;
    }
    return true;
}
}