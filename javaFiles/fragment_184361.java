TableColumn<Person, String> col = t.getTableColumn();
int row = t.getTablePosition().getRow();
ObservableValue<String> ov = col.getCellObservableValue(row);
if (ov instanceof WritableValue) {
    ((WritableValue<String>)ov).setValue(t.getNewValue());
}