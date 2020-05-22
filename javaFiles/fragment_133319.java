private YouTubePlayer player = null;

//...

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //find views by ID
    youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
    urlText = (EditText) findViewById(R.id.url);
    btnGo = (View) findViewById(R.id.btn_go);
    btnGo.setOnClickListener(onClickListener());

}

private YouTubePlayer.OnInitializedListener onInitialization() {
    return new YouTubePlayer.OnInitializedListener() {
        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
            if (!wasRestored) {
                //Keep doing what you're doing, and when finished...
                this.player = youTubePlayer;
            }
        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            //...
        }
    };
}

private View.OnClickListener onClickListener() {
    return new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(player == null) {
                youTubeView.initialize(API_KEY, onInitialization());
            } else {
                player.loadVideo(urlText.getText().toString().trim());
                player.play();
            }
        }
    };