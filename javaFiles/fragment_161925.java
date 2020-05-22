public void onCompletion(MediaPlayer mp) {
    if (mCompatMode && mNextPlayer != null) {
        mNextPlayer.prepare();
        mNextPlayer.start();
    }
}