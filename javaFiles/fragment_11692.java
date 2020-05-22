Column<T, Boolean> checkColumn = new Column<T, Boolean>(new CheckboxCell()) {
    @Override
        public Boolean getValue(T object) {
            return getSelectionModel().isSelected(object);
        }
    };
    checkColumn.setFieldUpdater(new FieldUpdater<T, Boolean>() {
        @Override
        public void update(int index, T object, Boolean value) {
            getSelectionModel().setSelected(object, value);
            dataProvider.refresh();
        }
    });

myDataGrid.setSelectionModel(getSelectionModel(), DefaultSelectionEventManager.<T> createCheckboxManager(0));

Header<Boolean> selectAllHeader = new Header<Boolean>(new HeaderCheckbox()) {

    @Override
    public Boolean getValue() {
        for (T item : getVisibleItems()) {
            if (!getSelectionModel().isSelected(item)) {
                return false;
            }
        }
        return getVisibleItems().size() > 0;
    }
};
selectAllHeader.setUpdater(new ValueUpdater<Boolean>() {

    @Override
    public void update(Boolean value) {
        for (T object : getVisibleItems()) {
            getSelectionModel().setSelected(object, value);
        }
    }
});
myDataGrid.addColumn(checkColumn, selectAllHeader);