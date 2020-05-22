@Override
protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
    if (resultCode == RESULT_OK) {
        mVideoId = getVideoId(data.getStringExtra("url"));
        mPlayer.release();
        mYoutubeplayerView.initialize(mApiKey, this);
    }
}