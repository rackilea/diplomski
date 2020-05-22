@Override
public Object getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null || value.trim().isEmpty()) {
        return null;
    }

    // ...
}