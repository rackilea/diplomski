private static <S,T> TableColumn<S,T> createColumn(String title, Function<S, Property<T>> property) {
    TableColumn<S,T> col = new TableColumn<>(title);
    col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
    col.setOnEditCommit(edit -> {
        S rowValue = edit.getRowValue();
        property.apply(rowValue).setValue(edit.getNewValue());
    });
    return col ;
}