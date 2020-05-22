@FacesConverter("longConverter")
public class FacesLongConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return Long.parseLong(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Long) value).toString();
    }

}