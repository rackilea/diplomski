public void validateEmailAndPassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    UIInput emailComponent = (UIInput) component.getAttributes().get("emailComponent");
    String email = (String) emailComponent.getValue();
    String password = (String) value;

    // ...
}