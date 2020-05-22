public class AccountNumberValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (StringUtils.isEmpty(value)) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Field mandatory");
            message.setDetail("Dedicated Cash Account Number is mandatory");
            throw new ValidatorException(message);
        }
    }

}