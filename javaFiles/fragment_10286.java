@FacesConverter("answerConverter")
public class AnswerConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) throws ConverterException {
        // Write code to convert Answer to its unique String representation for usage in HTML/HTTP. E.g.
        return String.valueOf(((Answer) modelValue).getId());
    }

    @Override 
    public Object getAsObject(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
        // Write code to convert unique String representation of Answer to concrete Answer for usage in Java/JSF. E.g.
        return yourAnswerService.find(Long.valueOf(submittedValue));
    }

}