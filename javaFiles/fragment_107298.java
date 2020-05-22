@Override
public void onRestoreInstanceState(Bundle icicle) {
    super.onRestoreInstanceState(icicle);
    String path = icicle.getString("path", DEFAULT_TRACK);
    int time = icicle.getInt("time", 0);
    boolean isPlaying = icicle.getBoolean("isPlaying", false);
    this.initialize(path, time, isPlaying);
}