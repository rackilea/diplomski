public DefaultProfileTableFieldFactory() {
}

@Override
public Field createField(Container container, Object itemId, Object propertyId, Component uiContext) {

    if (propertyId.equals(YOURCUSTOMPROP)) {
        Select select = new Select();
        select.addItem(ITEM1);
        select.addItem(ITEM2);
        select.addItem(ITEM3);

        return new SelectCustomField(select, String.class);
    } else {
        return super.createField(container, itemId, propertyId, uiContext);
    }
}


private static class SelectCustomField extends FieldWrapper<String> {

    protected SelectCustomField(Field wrappedField, Class<? extends String> propertyType) {
        super(wrappedField, propertyType);
        VerticalLayout l = new VerticalLayout();
        l.addComponent(wrappedField);
        setCompositionRoot(l);
        l.setSizeUndefined();
        this.setSizeUndefined();
        wrappedField.setSizeUndefined();
    }

    @Override
    protected String parse(Object value) throws ConversionException {
        // parse value from select to your model
    }

    @Override
    protected Object format(String value) {
        // format model from your model to value to be shown        
    }

}