@FXML  public void initialize(URL location, ResourceBundle resources) {

mp = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL).toExternalForm()));
    media.setMediaPlayer(mp);
    media.setSmooth(true);
    mp.setAutoPlay(true);

    Timeline tm = new Timeline(new KeyFrame(Duration.millis(3000), new KeyValue(media.opacityProperty(),  0.0)));
    tm.setDelay(Duration.millis(5500));
    tm.play();
}