Task task = new Task<Void>() {
    @Override public Void call() {
        for(int i=0; i<filmInfoList.size(); i++){
            updateProgress(i+1, filmInfoList.size());
            if(filmInfoList.get(i).getImageURL() != null) {
                FilmSearchResult film = filmInfoList.get(i);
                Image searchItemImage = new Image(film.getImageURL());
                ImageView searchItemImageView = new ImageView(searchItemImage);
                searchItemImageView.setPreserveRatio(true);

                searchItemImageView.setOnMouseClicked(e -> showDetails(film));

                Platform.runLater(() -> {
                    searchmoviesTilePane.getChildren().add(searchItemImageView);
                });
            }
        }

        return null;
    }
};


// ....

private void showDetails(FilmSearchResult film) {
    // show details for film...
}