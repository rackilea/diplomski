videoview.setOnPreparedListener(new OnPreparedListener() {
    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.setVolume(0, 0);
    }
});