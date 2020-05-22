private WritableImage textToImage(String text) {

    Text t = new Text(text);
    Scene scene = new Scene(new StackPane(t));
    return t.snapshot(null, null);
}