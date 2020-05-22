final Callback<TreeItem<Person>, ObservableValue<Boolean>> getSelectedProperty =
        (TreeItem<Person> item) -> {
    if (item instanceof CheckBoxTreeItem<?>) {
        return ((CheckBoxTreeItem<?>)item).selectedProperty();
    }
    return null;
}; 
final StringConverter<TreeItem<Person>> converter = 
        new StringConverter<TreeItem<Person>>() {

    @Override
    public String toString(TreeItem<Person> object) {
        Person item=object.getValue();
        return item.getName();
    }

    @Override
    public TreeItem<Person> fromString(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
};