private <S,T> TableColumn<S,T> column(String text, Function<S,Property<T>> prop, 
    Function<T,String> textExtractor) {

    TableColumn<S,T> col = new TableColumn<>(text);
    col.setCellValueFactory(cellData -> prop.apply(cellData.getValue()));
    col.setCellFactory(c -> new TableCell<S,T>() {
        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(textExtractor.apply(item));
            }
        }
    });
    return col ;
}