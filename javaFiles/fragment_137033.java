@Override
public void onCreate() {
    super.onCreate();

    player = MediaPlayer.create(this, R.raw.idil);
    player.setVolume(100,100);
    player.setLooping(true);

}