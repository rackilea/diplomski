public class Song {

    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty artist = new SimpleStringProperty();
    private final StringProperty album = new SimpleStringProperty();
    private Media music;
    private MediaPlayer mp;
    private Image coverArt;

    public Song(File file) {
        music = new Media(file.toURI().toString());
        music.getMetadata().addListener((Change<? extends String, ? extends Object> c) -> {
            if (c.wasAdded()) {
                if ("artist".equals(c.getKey())) {
                    setArtist(c.getValueAdded().toString());
                } else if ("title".equals(c.getKey())) {
                    setTitle(c.getValueAdded().toString());
                } else if ("album".equals(c.getKey())) {
                    setAlbum(c.getValueAdded().toString());
                } else if ("image".equals(c.getKey())) {
                    // maybe this needs to be a JavaFX property too: it is not clear from your question:
                    coverArt = (Image) c.getValueAdded();
                }
            }
        });
        mp = new MediaPlayer(music);
    }

    public void play() {
        mp.play();
    }

    public void pause() {
        mp.pause();
    }

    public void stop() {
        mp.stop();
    }

    public StringProperty titleProperty() {
        return title ;
    }

    public final String getTitle(){
        return titleProperty().get();
    }

    public final void setTitle(String title){
        titleProperty().set(title);
    }

    public StringProperty artistProperty() {
        return artist ;
    }

    public final String getArtist(){
        return artistProperty().get();
    }

    public final void setArtist(String artist){
        artistProperty.set(artist);
    }

    public StringProperty albumProperty() {
        return album ;
    }

    public final String getAlbum(){
        return albumProperty().get();
    }

    public final void setAlbum(String album){
        albumProperty().set(album);
    }

    public Image getCover(){
        return coverArt;
    }

    public MediaPlayer getMP(){
        return mp;
    }


}