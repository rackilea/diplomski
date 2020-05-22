@FacesValidator("input1Validator")
public class Input1Validator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (isInvalid(value)) {
            throw new ValidatorException(new FacesMessage("Invalid field!"));
        }
    }

}