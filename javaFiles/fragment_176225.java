public class MainActivity extends AppCompatActivity {
    private static final int UPDATE_LYRIC_TEXT_INTERVAL = 3000; // Change lyric text each 3 seconds.
    private int mCurrentInterval = 0;

    private TextView mLyricTextView;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLyricTextView = findViewById(R.id.lyricText);

        // I put a file named lyric.lrc in raw folder, for your case just open an input stream from a file.
        InputStream inputStream = getResources().openRawResource(R.raw.lyric);
        new ReadLyricTask(this).execute(inputStream);
    }

    private void displayLyricLineOnTextView(final String lyricLine) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mLyricTextView.setText(lyricLine);
            }
        }, mCurrentInterval);

        mCurrentInterval += UPDATE_LYRIC_TEXT_INTERVAL;
    }
}