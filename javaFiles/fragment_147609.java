public class HintController<E extends Enum<E>> implements ItemHoverHandler {

    private final Class<E> theEnumClass;

    public HintController(Class<E> enumClass) {
        theEnumClass = enumClass;
    }

    @Override
    public void onItemHover(ItemHoverEvent event) {
        FormItem formItem = event.getItem();
        E enumValue = Enum.valueOf(theEnumClass, (String) formItem.getValue());
        String prompt = (enumValue instanceof DataValue) ? getPromptForDataValue((DataValue<?>) enumValue) : null;
        formItem.setPrompt(prompt);
    }

    private String getPromptForDataValue(DataValue<?> dataValue) {
        return "<b>" + dataValue.getName() + "</b><br /><br />" + dataValue.getDescription();
    }

}