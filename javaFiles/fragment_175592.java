@FacesConverter(forClass=Bootenvironment.class)
public class BootenvironmentConverter implements Converter {

    @Override
    public void getAsString(FacesContext context, UIComponent component, Object modelValue) throws ConverterException {
        // Write code to convert Bootenvironment to its unique String representation. E.g.
        return String.valueOf(((Bootenvironment) modelValue).getId());
    }

    @Override 
    public void getAsObject(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
        // Write code to convert unique String representation of Bootenvironment to concrete Bootenvironment. E.g.
        return someBootenvironmentService.find(Long.valueOf(submittedValue));
    }

}