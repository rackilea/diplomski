public class MainActivity extends Activity  implements MediaPlayer.OnCompletionListener {
    //..
    SeekBar songProgressBar;
    //..

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songProgressBar=new SeekBar(this);