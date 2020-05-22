resetButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            textTimer.setText("" + 00 + ":"
                    + String.format("%02d", 00) + ":"
                    + String.format("%03d", 00));
            startTime = SystemClock.uptimeMillis();
            timeSwap=0;
        }
    });