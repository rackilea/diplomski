@Override
protected void onPause() {
    super.onPause();
    if (mediaPlayer != null) {
        mediaPlayer.pause();
        if (isFinishing()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}