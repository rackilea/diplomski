@FacesConverter(value = "userConverter", forClass = User.class)
public class UserConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, java.lang.String value) {

        return ConversionHelper.getAsObject(User.class, value);
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

        return ConversionHelper.getAsString(value);
    }
}