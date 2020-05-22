private int pausedOnFrame = 0;

AdvancedPlayer player = new AdvancedPlayer(fis);
player.setPlayBackListener(new PlaybackListener() {
    @Override
    public void playbackFinished(PlaybackEvent event) {
        pausedOnFrame = event.getFrame();
    }
});
player.play();
// or player.play(pausedOnFrame, Integer.MAX_VALUE);