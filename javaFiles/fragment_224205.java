public TilePane createTilePane() {
    // reuse large object
    Image image = new Image("https://media.forgecdn.net/avatars/141/115/636539774401917932.jpeg");

    TilePane tile = new TilePane();
    tile.setPrefColumns(5);
    for (int i = 0; i < 20; i++) {
        ImageView imageView = createImageView();
        imageView.setImage(image);
        imgArray[i] = imageView;
        tile.getChildren().add(imageView);
    } //for
    return tile;
} //createTilePane()

private ImageView createImageView() {
    ImageView image = new ImageView();
    image.setFitWidth(100d);
    image.setFitHeight(100d);
    return image;
}

public void setImage(int index, String url) {
    ImageView imageView = imgArray[index];
    Image image = new Image(url);

    // change image in ImageView that was added to the scene
    imageView.setImage(image);
}