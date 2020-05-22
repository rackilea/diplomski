final AudioClip ping = new AudioClip(
  "http://soundbible.com/grab.php?id=1815&type=wav"
);

webView.getEngine().locationProperty().addListener(new ChangeListener<String>() {
  @Override public void changed(ObservableValue<? extends String> observable, String oldLocation, String newLocation) {
    if (newLocation != null && newLocation.startsWith("http://www.google.com") {
      ping.play();
    } 
  }
});