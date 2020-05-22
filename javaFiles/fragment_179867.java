@FacesConverter(value = "playerConverter")
public class PlayerConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }

        long idValue;
        try {
            idValue = Long.parseLong(value);
        }
        catch (NumberFormatException ex)
        {
            return null;
        }

        ServicePlayer servicePlayer = context.getApplication()
                .evaluateExpressionGet(context, "#{servicePlayer}",
                        ServicePlayer.class);
        Player player = servicePlayer.getPlayerByID(idValue);
        return player;

    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
        String string = null;
        if (value instanceof Player) {
            string = ((Player) value).getId();
        }
        return string;
    }

}