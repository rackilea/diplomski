videoView.setOnPreparedListener(new OnPreparedListener() {
    @Override
    public void onPrepared(MediaPlayer mplayer) {
        mplayer.setLooping(true);
    }
});