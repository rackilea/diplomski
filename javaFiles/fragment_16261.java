TimerTask task = new TimerTask() {
    public void run() {
        elapsedTime++;//amount of time passed
        timeLeft.setText("" + (time - elapsedTime));

        if (time - elapsedTime == 0) {
            cancel();
            score1 = 0;//resets score
            question.setText("GAME OVER");
        }
    }
};