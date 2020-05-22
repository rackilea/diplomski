public class LiveComboBoxTableCell<S,T> extends TableCell<S, T> {

    private final ComboBox<T> comboBox ;

    public LiveComboBoxTableCell(ObservableList<T> items) {
        this.comboBox = new ComboBox<>(items);

        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        comboBox.valueProperty().addListener(new ChangeListener<T>() {
            @Override
            public void changed(ObservableValue<? extends T> obs, T oldValue, T newValue) {
                // attempt to update property:
                ObservableValue<T> property = getTableColumn().getCellObservableValue(getIndex());
                if (property instanceof WritableValue) {
                    ((WritableValue<T>) property).setValue(newValue);
                }
            }
        });
    }

    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            comboBox.setValue(item);
            setGraphic(comboBox);
        }
    }
}