@FacesConverter("lowerConverter")
public class LowerConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext cx, UIComponent component,
                              String value) throws ConverterException {
        if(value == null) {
            return null;
        }
        Locale locale = cx.getExternalContext().getRequestLocale();
        return value.toLowerCase(locale);
    }

    @Override
    public String getAsString(FacesContext cx, UIComponent component,
                              Object value) throws ConverterException {
        if(value == null) {
            return null;
        }
        return value.toString();
    }
}