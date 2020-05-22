public void setNextMediaPlayer(MediaPlayer next) {
    if (mCompatMode) {
        mNextPlayer = next;
    } else {
        super.setNextMediaPlayer(next);
    }
}