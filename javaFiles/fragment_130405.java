/**
     * Anonymous inner class for CountdownTimer
     */
    new CountDownTimer(3000, 1000) { // Convenient timing object that can do certain actions on each tick

        /**
         * Handler of each tick.
         * @param millisUntilFinished - millisecs until the end
         */
        @Override
        public void onTick(long millisUntilFinished) {
            // Currently not needed
        }

        /**
         * Listener for CountDownTimer when done.
         */
        @Override
        public void onFinish() {
             ds.open();
              String quotes=ds.getRandomQuote();
              textView.setText(quotes);
              ds.close(); 
        }
    }.start();