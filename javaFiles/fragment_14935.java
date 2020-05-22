/*Request scoped managed bean*/
public class PasswordValidationBean {
  private String input1;
  private String input2;
  private boolean input1Set;

  public void validateField(FacesContext context, UIComponent component,
      Object value) {
    if (input1Set) {
      input2 = (String) value;
      if (input1 == null || input1.length() < 6 || (!input1.equals(input2))) {
        ((EditableValueHolder) component).setValid(false);
        context.addMessage(component.getClientId(context), new FacesMessage(
            "Password must be 6 chars+ & both fields identical"));
      }
    } else {
      input1Set = true;
      input1 = (String) value;
    }
  }
}