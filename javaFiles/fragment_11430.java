@FXML
public TableView<Avatar> produits;

@FXML
public TableColumn<Avatar, byte[]> imageColumn;

@FXML
public void initialize() {
    ...
    imageColumn.setCellFactory(param -> new TableCell<Avatar, byte[]>() {

        private ImageView imageView = new ImageView();

        @Override
        protected void updateItem(byte[] item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                imageView.setImage(getImageFromBytes(item));
                setGraphic(imageView);
            }
            this.setItem(item);
        }
    });
    ...
}