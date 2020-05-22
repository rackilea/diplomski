timer = new CountDownTimer(5000, 10) { // adjust the milli
        // seconds here
        public void onTick(long millisUntilFinished) {
            text.setText(""
                    + String.format(
                    "%02d:%03d",
                    TimeUnit.MILLISECONDS
                            .toSeconds(millisUntilFinished)
                            - TimeUnit.MINUTES
                            .toSeconds(TimeUnit.MILLISECONDS
                                    .toMinutes(millisUntilFinished)),
                    TimeUnit.MILLISECONDS
                            .toMillis(millisUntilFinished)
                            - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS
                            .toSeconds(millisUntilFinished))));

        }

        public void onFinish() {
            text.setText("GameOver.");
            //cancel(); <-this is redundant
        }
    }.start();