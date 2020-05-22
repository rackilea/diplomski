public void onClick (View view) 
    {
        mCountDownTimer.cancel();
        score++;
        tvscore.setText(String.valueOf(score));
        mCountDownTimer.start();

    }