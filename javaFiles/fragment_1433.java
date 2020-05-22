public class SoundPlayer {

    private final MediaPlayer mediaPlayer ;

    public SoundPlayer(URL url) {
        this.mediaPlayer = new MediaPlayer(new Media(url));
    }

    public void play() {
        mediaPlayer.play();
    }

    public double getVolume() {
        return mediaPlayer.getVolume();
    }

    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }

    public boolean isSoundOn() {
        return ! mediaPlayer.isMuted();
    }

    public void setSoundOn(boolean soundOn) {
        mediaPlayer.setMuted(! soundOn);
    }
}