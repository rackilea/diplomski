public void falseAnswerPoints() {
    try {
        MediaPlayer playError = MediaPlayer.create(QuizActivity.this, R.raw.error);
        playError.start();
    }
    catch (NullPointerException e) {
        // Set a breakpoint there to inspect the state of your app
        // Then rethrow the exception to have it logged, and why not
        // log extra info.
    }
}