@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ...

    // change the music vol instead of ringtone vol
    // when hardware volume buttons are pressed
    setVolumeControlStream(AudioManager.STREAM_MUSIC);
}