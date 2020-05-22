public class MainActivity extends Activity  implements MediaPlayer.OnCompletionListener {
    // .. code
    SeekBar songProgressBar;
    // .. code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // .. code

        songProgressBar = (SeekBar) findViewById(R.id.songProgressBar);
        // .. code