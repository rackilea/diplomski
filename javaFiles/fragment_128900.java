Image image = new Image(IMAGE_LOC);
ImageView imageView = new ImageView(image);
Glow glow = new Glow();
imageView.effectProperty().bind(
    Bindings.when(imageView.hoverProperty()).then(glow).otherwise(null)
);
imageView.setOnMouseClicked(event -> showInfoPopup());