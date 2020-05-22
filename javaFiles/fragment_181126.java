sdrPlayer.setOnPreparedListener(new OnPreparedListener() {
    @Override
    public void onPrepared(MediaPlayer mp) {
        sdrPlayer.start();
    }
});