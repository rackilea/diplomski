private void initialize(String path, int time, boolean isPlaying) {
    mMediaPlayer.setDataSource(path);
    mMediaPlayer.seekTo(time);
    if (isPlaying) mMediaPlayer.start();
    findViewById(R.id.my_play_button).setBackgroundResource(isPlaying? R.drawable.pause_button: R.drawable.play_button);
}