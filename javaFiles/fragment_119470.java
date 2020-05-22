mVideoView = findViewById(R.id.video_view);
if (savedInstanceState != null) {
   mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
}
MediaController mediaController = new MediaController(this);
mVideoView.setMediaController(mediaController); // Change in this line.