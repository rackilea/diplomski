@FacesConverter("userDetailsConverter")
public class UserDetailsConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof UserDetails) || ((UserDetails) value).getId() == null) {
            return null;
        }

        return String.valueOf(((UserDetails) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+")) {
            return null;
        }

        UserDetails details = new UserService().getDetails(Integer.valueOf(value));

        if (details == null) {
            throw new ConverterException(new FacesMessage("Unknown user ID: " + value));
        }

        return details;
    }

}