public void play() {
    mainTimer = new Timer();
    subTimer = new Timer();
    mainTimerTask = new MyTimerTask();
    subTimerTask = new MyTimerTask();

    mainTimer.schedule(mainTimerTask, 0, MILLIS_IN_MINUTE / bpm);
    subTimer.schedule(subTimerTask, (300 * (100+swing)) / bpm, MILLIS_IN_MINUTE / bpm);

}

private void  playSound() {
    final MediaPlayer mp = MediaPlayer.create(context, SOUND);
    mp.start();
    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mp) {
            mp.release();
        };
    });
}

class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        playSound();
    }
}