@FacesValidator("sessionIdValidator")
public class SessionIdValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        // ...

        if (yourDataService.existSessionId(value)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Session ID is already in use, please choose another.", null));
        }
    }

}