@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    private static final Pattern PATTERN = Pattern.compile("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)");

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null || ((String) value).isEmpty()) {
            return; // Let required="true" handle.
        }

        if (!PATTERN.matcher((String) value).matches()) {
            String summary = context.getApplication().evaluateExpressionGet(context, "#{label.email}", String.class);
            String detail = context.getApplication().evaluateExpressionGet(context, "#{label.email_detail}", String.class);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
        }
    }

}