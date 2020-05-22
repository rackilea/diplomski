h.postDelayed(new Runnable() {
    public void run() {
        timePassed++;
        timeLeft = (maxTime - timePassed) / 10;
        timeLeftStr = "Time left: " + timeLeft + " seconds";
        timer.setText(timeLeftStr);

        if (timeLeft <= 0) {
            started = false;

            h.removeCallbacksAndMessages(null);

            setupGameOver(restartBtn, header1, header2, timer);
        } else {
            // run again.
            h.postDelayed(this, 100);
        }

    }
}, 100);