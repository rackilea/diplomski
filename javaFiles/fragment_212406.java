public class Bean {
    private List<Field> fields;
    private DataModel<Field> fieldModel;

    public Bean() {
        fields = loadItSomehow();
        fieldModel = new ListDataModel<Field>(fields);
    }

    public Converter getFieldConverter() {
        return fieldModel.getRowData().getConverter();
    }

    public void validateField(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        fieldModel.getRowData().getValidator().validate(context, component, value);
    }

    // ...
}