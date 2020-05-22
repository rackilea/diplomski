@Override
public ListCell<TextFlow> call(ListView<TextFlow> param) {
    return new ListCell<TextFlow>() {
        @Override
        protected void updateItem(TextFlow item, boolean empty) {
            super.updateItem(item, empty);

            if (item != null) {
                setStyle("-fx-control-inner-background: blue;");
                setGraphic(item);
            } else {
                setStyle(null);
                setGraphic(null);
                System.out.println("Item is null.");
            }

        }
    };
}