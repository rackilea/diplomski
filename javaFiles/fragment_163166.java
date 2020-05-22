public class UserConverter implements Converter {

    private UserDAO userDAO = SomeDAOManager.getUserDAO();

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((User) value).getId());
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return userDAO.find(Long.valueOf(value));
    }

}