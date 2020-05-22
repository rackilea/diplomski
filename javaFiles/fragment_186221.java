@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    SimpleExoPlayerView simpleExoPlayerView = findViewById(R.id.player_view);

    SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector(new DefaultBandwidthMeter.Builder().build()));

    SimpleCache downloadCache = new SimpleCache(new File(getCacheDir(), "exoCache"), new NoOpCacheEvictor());

    String uri = "http://dash.akamaized.net/akamai/bbb/bbb_1280x720_60fps_6000k.mp4";

    DataSource.Factory dataSourceFactory = new CacheDataSourceFactory(downloadCache, new DefaultDataSourceFactory(this, "seyed"));

    MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(uri));

    player.addListener(new Player.EventListener() {
        @Override
        public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
            Log.d("exo", "timeLine Changed");
        }

        @Override
        public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

        }

        @Override
        public void onLoadingChanged(boolean isLoading) {
            Log.d("exo", "loding changed= " + isLoading);
        }

        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
            Log.d("exo", "state changed");
        }

        @Override
        public void onRepeatModeChanged(int repeatMode) {

        }

        @Override
        public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

        }

        @Override
        public void onPlayerError(ExoPlaybackException error) {
            Log.e("exo", "exoplayer error", error);
        }

        @Override
        public void onPositionDiscontinuity(int reason) {

        }

        @Override
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

        }

        @Override
        public void onSeekProcessed() {
            Log.d("exo", "seek processed");
        }
    });
    player.prepare(mediaSource);

    simpleExoPlayerView.setPlayer(player);

    player.setPlayWhenReady(true);

}