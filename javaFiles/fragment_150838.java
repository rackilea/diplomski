CountDownTimer timer = new CountDownTimer(2000, 1000) {

    public void onTick(long millisUntilFinished) {
    }

    public void onFinish() {
        mTextField.setText("");
    }

};

if(score > highscore){
highscore = score;
mTextField.setText("New HighScore");
timer.start();
}