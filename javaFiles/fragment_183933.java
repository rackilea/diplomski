@FacesConverter("roleConverter")
public class RoleConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.equals("")) {
            return null;
        }
        Role role = Role.valueOf(value);
        return role;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Role) || (value == null)) {
            return null;
        }
        return ((Role)value).toString();
    }

}