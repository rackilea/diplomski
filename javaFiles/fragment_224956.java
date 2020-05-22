public void onClick(View v) {
        // get the name from edittext and storing into string variable
        long timeVal = Long.parseLong(editTime1.getText().toString());

        if (!timerHasStarted) {
            countDownTimer = new MyCountDownTimer(timeVal, interval);
            text.setText(text.getText() + String.valueOf(timeVal / 1000));
            countDownTimer.start();
            timerHasStarted = true;
            startButton.setText("STOP");
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
            startButton.setText("RESTART");
        }
    }