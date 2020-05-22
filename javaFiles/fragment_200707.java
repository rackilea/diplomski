mPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {

    public boolean onError(MediaPlayer mp, int what, int
            extra) {
        onError(mPlayer, what, extra);
        return true;
    }
});