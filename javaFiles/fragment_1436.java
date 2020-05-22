public class SoundPlayer {

    private final MediaPlayer mediaPlayer ;

    // ...


    public DoubleProperty volumeProperty() {
        return mediaPlayer.volumeProperty();
    }

    // ...
}