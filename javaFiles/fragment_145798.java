public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String mVideoId = "5xVh-7ywKpE";

    String mApiKey = "YOUR_API_KEY";

    YouTubePlayerView mYoutubeplayerView;

    YouTubePlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYoutubeplayerView = (YouTubePlayerView) findViewById(R.id.player);

        mYoutubeplayerView.initialize(mApiKey, this);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilter();
            }
        });

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer youTubePlayer, boolean b) {
        mPlayer = youTubePlayer;
        mPlayer.loadVideo(mVideoId);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        if (resultCode == RESULT_OK) {
            mVideoId = getVideoId(data.getStringExtra("url"));
            mPlayer.release();
            mYoutubeplayerView.initialize(mApiKey, this);
        }
    }

    private String getVideoId(String url) {
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(url);

        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public void openFilter() {
        Intent askIntent = new Intent(this, FilterActivity.class);
        startActivityForResult(askIntent, 1);
    }
}