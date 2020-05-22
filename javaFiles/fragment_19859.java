public class MainActivity extends ReactActivity {
    /* Any previous code you had here */
    [...]

    /* Override the onCreate function here */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* Add this line to keep the original behavior of onCreate() */
        super.onCreate(savedInstanceState);
        /* This one does the trick */
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }
}