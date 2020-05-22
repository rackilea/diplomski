private void startEverything() {
    startMyAnimation();
    playMusic()
}

private void startMyAnimation() {
    ObjectAnimator progressAnimator = ObjectAnimator.ofInt(mProgress, "progress", 0, 10000);
    progressAnimator.setDuration(10000);
    progressAnimator.setInterpolator(new LinearInterpolator());
    progressAnimator.start();
}

private void playMusic() {
    final MediaPlayer soundPlayer= MediaPlayer.create(getContext(), R.raw.your_bgm);
    soundPlayer.start();


    Handler musicStopHandler = new Handler();
    Runnable musicStopRunable = new Runnable() {
        @Override
        public void run() {
            soundPlayer.stop();
        }
    };

    musicStopHandler.postDelayed(musicStopRunable, 10000);
}