public class VideoPlaying extends Activity {
    private MediaController mc;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    VideoView vd = (VideoView) findViewById(R.id.VideoView);
    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"+R.raw.VideoName);
    mc = new MediaController(this);
    vd.setMediaController(mc);
    vd.requestFocus();
    vd.setVideoURI(uri);
    vd.start();
    }
    }