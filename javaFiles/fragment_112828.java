Map<String, SoftReference<Image>> imageCache = new HashMap<>();

.....

searchButton.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e)
    {
        input = searchBar.getText();
        final String urlString = "url link" + input; // Or whatever the URL

        final SoftReference<Image> softRef = imageCache.get(urlString);
        Image image = null;

        if (softRef == null || softRef.get() == null) {
            image = new Image(urlString);
            imageCache.put(urlString, new SoftReference<>(image));
        }
        else
            image = softRef.get();

        imageView.setImage(image);
        searchBar.clear();
    }
});