public <S,T> Callback<TableColumn<S,T>, TableCell<S,T>> 
        cellFactory(Function<T, String> textExtractor) {

    return col -> new TableCell<S,T>() {
        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty) ;
            if (empty || item == null) {
                setText(null);
            } else {
                setText(textExtractor.apply(item));
            }
        }
    };
}