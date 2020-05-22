public class My_videos extends Activity {
    private VideoView vid;
    String night;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        Bundle bdl = getIntent().getExtras();
        night = bdl.getString("video");

        vid = (VideoView) findViewById(R.id.videoView1);

        if (night.equalsIgnoreCase("button1")) {
            vid.setVideoURI(Uri.parse("android.resource://" + getPackageName()
                    + "/" + R.raw.a));
            vid.setMediaController(new MediaController(My_videos.this));
            vid.requestFocus();
            vid.start();
        } else if (night.equalsIgnoreCase("button2")) {
            vid.setVideoURI(Uri.parse("android.resource://" + getPackageName()
                    + "/" + R.raw.b));
            vid.setMediaController(new MediaController(My_videos.this));
            vid.requestFocus();
            vid.start();
        } else if (night.equalsIgnoreCase("button3")) {
            vid.setVideoURI(Uri.parse("android.resource://" + getPackageName()
                    + "/" + R.raw.c));
            vid.setMediaController(new MediaController(My_videos.this));
            vid.requestFocus();
            vid.start();
        } else if (night.equalsIgnoreCase("button4")) {
            vid.setVideoURI(Uri.parse("android.resource://" + getPackageName()
                    + "/" + R.raw.d));
            vid.setMediaController(new MediaController(My_videos.this));
            vid.requestFocus();
            vid.start();
        } else if (night.equalsIgnoreCase("button5")) {
            vid.setVideoURI(Uri.parse("android.resource://" + getPackageName()
                    + "/" + R.raw.e));
            vid.setMediaController(new MediaController(My_videos.this));
            vid.requestFocus();
            vid.start();
        }
    }
}