@Override
public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    if (value == null) {
        return; // This should normally not be hit when required="true" is set.
    }

    String phoneNumber = (String) value; // You need to cast it to the same type as returned by Converter, if any.

    if (!phoneNumber.matches("04\\d{8}")) {
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please enter a valid mobile phone number.", null));
    }
}