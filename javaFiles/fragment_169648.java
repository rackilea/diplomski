pieceData = FXCollections.observableArrayList("Boot", "Car", "Dog", "Hat", "Iron",
                                                  "Ship", "Thimble", "Wheelbarrow");
pieceSelection.setItems(pieceData);

pieceSelection.setCellFactory(e -> new ListCell<String>() {
    private ImageView view = new ImageView();
    @Override
    public void updateItem(String name, boolean empty) {
        super.updateItem(name, empty);
        if(empty) {
            setGraphic(null);
        }
        else {
            view.setImage(new Image("whatever the filepath to your image is"));
            // Add other set up for ImageView dimensions etc
            setGraphic(view);
        }
    }
});