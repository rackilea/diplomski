mPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {

    public boolean onError(MediaPlayer mp, int what, int
            extra) {
        // Calling onError of MusicService instead this onError method.
        MusicService.this.onError(mPlayer, what, extra);
        return true;
    }
});