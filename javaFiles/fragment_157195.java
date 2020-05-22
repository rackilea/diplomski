@Named("ValidatorController")
@ViewScoped
public class FormValidator implements Validator {

    public FormValidator() {
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value.equals("test")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "  Session ID is already in use, please choose another.", null));
        }
    }

    public void validatebean(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value.equals("test")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "  Session ID is already in use, please choose another.", null));
        }
    }

}