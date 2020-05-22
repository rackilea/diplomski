CellTable<String> table = new CellTable<String>();

final MultiSelectionModel<String> selectionModel = new MultiSelectionModel<>();
table.setSelectionModel(selectionModel);

CheckboxCell selectedCell = new CheckboxCell();
Column<String, Boolean> selectedCol = new Column<String, Boolean>(selectedCell) {
    @Override
    public Boolean getValue(String object) {
        // return object.isSelected();
        return selectionModel.isSelected(object);
    }
};
table.addColumn(selectedCol);

table.addColumn(new TextColumn<String>() {
    @Override
    public String getValue(String object) {
        return object;
    }
});

List<String> values = new ArrayList<>();
for(int i = 0; i < 10; i++)
    values.add("Line " + (i + 1));
table.setRowData(values);