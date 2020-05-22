@Override
public void onSaveInstanceState(Bundle icicle) {
    super.onSaveInstanceState(icicle);
    icicle.putString("path", mMediaPath);
    icicle.putInt("time", mMediaPlayer.getCurrentPosition());
    icicle.putBoolean("isPlaying", mMediaPlayer.isPlaying());
}