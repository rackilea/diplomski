public void falseAnswerPoints() {
    if (!mPlayingSound) {
        mPlayingSound = true;

        MediaPlayer playError = MediaPlayer.create(QuizActivity.this, R.raw.error);
        playError.start();
    }
}