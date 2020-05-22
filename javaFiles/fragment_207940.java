iconCol.setCellFactory(col -> new TableCell<Hiscore, String>() {
    private final ImageView imageView = new ImageView();
    @Override 
    protected void updateItem(String imageURL, boolean empty) {
        super.updateItem(image, empty) ;
        if (empty) {
            setGraphic(null);
        } else {
            Image image = new Image(imageURL, true);
            imageView.setImage(image);
            setGraphic(imageView);
        }
    }
});