public class CustomPropertyEditorFactory implements Callback<Item, PropertyEditor<?>> {

    @Override public PropertyEditor<?> call(Item item) {
        Class<?> type = item.getType();

        if (type == String.class) {
            return createTextEditor(item);  
        }

        if (type != null && type == javafx.collections.ObservableList.class) {
            return createCheckComboBoxEditor(item, Person.createDemoList());
        }

        return null; 
    }

    public final PropertyEditor<?> createTextEditor(PropertySheet.Item property) {

        return new AbstractPropertyEditor<String, TextField>(property, new TextField()) {

            @Override protected StringProperty getObservableValue() {
                return getEditor().textProperty();
            }

            @Override public void setValue(String value) {
                getEditor().setText(value);
            }
        };
    }

    public final <T> PropertyEditor<?> createCheckComboBoxEditor(PropertySheet.Item property, final Collection<T> choices) {

        return new AbstractPropertyEditor<ObservableList<T>, CheckComboBox<T>>(property, new CheckComboBox<>()) {

            private ListProperty<T> list;

            { 
                getEditor().getItems().setAll(choices);
            } 

            @Override
            protected ListProperty<T> getObservableValue() {
                if (list == null) {
                    list = new SimpleListProperty<>(getEditor().getCheckModel().getCheckedItems());
                }
                return list;
            }

            @Override
            public void setValue(ObservableList<T> checked) {
                checked.forEach(getEditor().getCheckModel()::check);
            }
        };
    }
}